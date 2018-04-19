package cmu.hopon.service;

import cmu.hopon.domain.Score;
import cmu.hopon.domain.User;
import cmu.hopon.repository.ScoreRepository;
import cmu.hopon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ScoreRepository scoreRepository;

    public static final String USER_LOGOUT_SUCCESS_MESSAGE = "Successfully logged out";
    public static final String USER_LOGOUT_FAILURE_MESSAGE = "Failed to logout";

    public static final String USER_LOGIN_SUCCESS_MESSAGE = "Successfully loggin in";
    public static final String USER_LOGIN_FAILURE_MESSAGE = "Failed to login";

    public static final String USER_SIGNUP_SUCCESS_MESSAGE = "Successfully signed up";
    public static final String USER_SIGNUP_FAILURE_MESSAGE = "Failed to sign up";

    public static final String USER_UPDATE_SUCCESS_MESSAGE = "Successfully updated";

    private static long[] codeList = new long[] {123,345,678,911,922,933,944,955};
    private static List<String> tokenList = new ArrayList<>();

    public User login(String username, long code) {

        User exist = userRepository.findByUsername(username);
        if(exist!=null && exist.getCode()==code){
            User user = userRepository.findByUsername(username);
            String token = genToken();
            user.setToken(token);
            tokenList.add(token);
            userRepository.save(user);
            return user;
        }else{
            return null;
        }
    }

    public String updateScore(String token, int ans, int right) {

        //TODO Fazer verificaçoes e ver da segurança
        User exist = userRepository.findByToken(token);
        exist.getScore().setAnswered(ans);
        exist.getScore().setCorrect(right);
        userRepository.save(exist);

        return USER_UPDATE_SUCCESS_MESSAGE;
    }

    public String logout(String token) {

        User user = userRepository.findByToken(token);
        user.setToken(null);
        userRepository.save(user);
        return USER_LOGOUT_SUCCESS_MESSAGE;
    }

    public String signUp(String username, long code) {

        boolean contains = LongStream.of(codeList).anyMatch(x -> x == code);
        if (contains && userRepository.findByUsername(username)==null){
            User user = new User();
            user.setUsername(username);
            user.setCode(code);

            Score score = new Score();
            score.setAnswered(0);
            score.setCorrect(0);

            scoreRepository.save(score);
            user.setScore(score);

            try{
                userRepository.save(user);
                return USER_SIGNUP_SUCCESS_MESSAGE;
            }catch (Exception e){
                return USER_SIGNUP_FAILURE_MESSAGE;
            }
        }else{
            return USER_SIGNUP_FAILURE_MESSAGE;
        }
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    private String genToken(){
        String token = UUID.randomUUID().toString();
        while (tokenList.contains(token)){
            token = UUID.randomUUID().toString();
        }
        return token;
    }

    public String signUp(User user) {

        boolean contains = LongStream.of(codeList).anyMatch(x -> x == user.getCode());
        if (contains && userRepository.findByUsername(user.getUsername())==null){

            Score score = new Score();
            score.setAnswered(0);
            score.setCorrect(0);
            score.setElapsedSeconds(0.0);

            Score currentScore = new Score();
            currentScore.setAnswered(0);
            currentScore.setCorrect(0);
            currentScore.setElapsedSeconds(0.0);

            scoreRepository.save(score);
            scoreRepository.save(currentScore);

            user.setScore(score);
            user.setCurrentScore(currentScore);

            try{
                userRepository.save(user);
                return USER_SIGNUP_SUCCESS_MESSAGE;
            }catch (Exception e){
                return USER_SIGNUP_FAILURE_MESSAGE;
            }
        }else{
            return USER_SIGNUP_FAILURE_MESSAGE;
        }
    }

    public String updateUser(User user) {

        //TODO Fazer verificaçoes e ver da segurança
        User exist = userRepository.findByToken(user.getToken());
        exist.getScore().setAnswered(user.getScore().getAnswered());
        exist.getScore().setCorrect(user.getScore().getCorrect());
        exist.getScore().setElapsedSeconds(exist.getScore().getElapsedSeconds()
                +user.getCurrentScore().getElapsedSeconds());

        exist.getCurrentScore().setAnswered(user.getCurrentScore().getAnswered());
        exist.getCurrentScore().setCorrect(user.getCurrentScore().getCorrect());
        exist.getCurrentScore().setElapsedSeconds(user.getCurrentScore().getElapsedSeconds());

        exist.setCurrentMonument(user.getCurrentMonument());
        exist.setAnsweredLocations(user.getAnsweredLocations());

        userRepository.save(exist);

        return USER_UPDATE_SUCCESS_MESSAGE;
    }
}






