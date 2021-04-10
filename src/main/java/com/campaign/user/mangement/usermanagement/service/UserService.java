package com.campaign.user.mangement.usermanagement.service;

import com.campaign.user.mangement.usermanagement.dto.UserRequestDTO;
import com.campaign.user.mangement.usermanagement.entity.User;
import com.campaign.user.mangement.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserDetails(String id) {
        Optional <User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new IllegalArgumentException("User not found with id::" + id));
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public void saveUser(@Valid User user) {
        this.userRepository.insert(user);
        getUserDetails(user.getId());
    }

    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

    public void updateUser(User user, String id) {
        Optional <User>  userOptional =  this.userRepository.findById(id);
        userOptional.map( u -> this.userRepository.insert(user))
                .orElseThrow(() -> new IllegalArgumentException("User not found with id::" + id));
    }
}
