package cmu.hopon.service;

import cmu.hopon.domain.User;
import cmu.hopon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public static final String USER_LOGOUT_SUCCESS_MESSAGE = "Successfully logged out";
    public static final String USER_LOGOUT_FAILURE_MESSAGE = "Failed to logout";

    public static final String USER_SIGNUP_SUCCESS_MESSAGE = "Successfully signed up";
    public static final String USER_SIGNUP_FAILURE_MESSAGE = "Failed to sign up";

    private static long[] codeList = new long[] {123,345,678,911,922,933,944,955};

    public String login(String username, long code) {

        //TODO verify inputs and if username and code corresponds
        User user = userRepository.findByUsername(username);

        //TODO if user does not exist return error

        //TODO add token to list of tokens and check for repeated
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        userRepository.save(user);
        return token;

    }

    public String logout(String token) {

        User user = userRepository.findByToken(token);
        user.setToken(null);
        userRepository.save(user);
        return USER_LOGOUT_SUCCESS_MESSAGE;
    }

    public String signUp(User user) {

        //TODO username must be unique and the code must have nerver been used before


        boolean contains = LongStream.of(codeList).anyMatch(x -> x == user.getCode());
        if (contains){
            userRepository.save(user);
            return USER_SIGNUP_SUCCESS_MESSAGE;
        }else{
            return USER_SIGNUP_FAILURE_MESSAGE;
        }


    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}






