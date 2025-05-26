package com.app.divyansh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.divyansh.model.User;
import com.app.divyansh.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public List<User> saveAllUsers(List<User> users) {
        return userRepository.saveAll(users);
    }
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User updateUser(String username, User updatedUser) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Error occured. User not found for this username"));
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setPassword(updatedUser.getPassword());
        user.setUserStatus(updatedUser.getUserStatus());
        return userRepository.save(user);
    }
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }
    public boolean validateCredentials(String username, String password) {
        Optional<User> is_user_present = userRepository.findByUsername(username);
        return is_user_present.isPresent() && is_user_present.get().getPassword().equals(password);
    }
}
