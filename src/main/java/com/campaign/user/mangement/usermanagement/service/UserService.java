package com.campaign.user.mangement.usermanagement.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.campaign.user.mangement.usermanagement.entity.User;
import com.campaign.user.mangement.usermanagement.repository.UserRepository;

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
    	User db_user =  getUserDetails(id);
    	user.setName(db_user.getName());
        this.userRepository.save(user);
    }
}
