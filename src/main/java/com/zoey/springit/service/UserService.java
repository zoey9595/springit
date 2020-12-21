package com.zoey.springit.service;

import com.zoey.springit.domain.User;
import com.zoey.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return user;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User... users) {
        for (User user : users) {
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }
}
