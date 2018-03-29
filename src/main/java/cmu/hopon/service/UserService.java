package cmu.hopon.service;

import cmu.hopon.domain.User;
import cmu.hopon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public static final String USER_LOGOUT_SUCCESS_MESSAGE = "Successfully logged out";
    public static final String USER_LOGOUT_FAILURE_MESSAGE = "Failed to logout";

    public String login(String username, long code) {

        //TODO verify inputs and if username and code corresponds
        User user = userRepository.findByUsername(username);

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

    public User signUp(User user) {

        //TODO username must be unique and the code must have nerver been used before

        userRepository.save(user);
        return user;


    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}






