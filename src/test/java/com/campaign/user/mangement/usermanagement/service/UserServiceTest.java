package com.campaign.user.mangement.usermanagement.service;

import com.campaign.user.mangement.usermanagement.entity.User;
import com.campaign.user.mangement.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Test
    void getAllUsers() {
        UserService userService = new UserService(userRepository);
        User expected = new User("Jones","9800012000" );
        //userRepository.insert(expected);
        /*List<User> users = userService.findAllUsers();
        User actual = users.get(users.size());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());*/
    }
}
