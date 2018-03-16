package cmu.hopon.service;

import cmu.hopon.domain.User;
import cmu.hopon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User login(User user) {
        return null;

    }

    public User logout(User user) {

            return null;
    }

    public User signUp(User user) {

        userRepository.save(user);
        return user;


    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}






