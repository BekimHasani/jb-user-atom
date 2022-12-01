package org.tenement.jbuseratom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tenement.jbuseratom.entity.User;
import org.tenement.jbuseratom.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }

    public User fetchUserById(Long userId){
        return userRepository
                .findById(userId)
                .get();
    }

    public User createUser(User user){
        return saveUser(user);
    }

    private User saveUser(User user) {
        return userRepository.save(user);
    }

    public User fetchUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
