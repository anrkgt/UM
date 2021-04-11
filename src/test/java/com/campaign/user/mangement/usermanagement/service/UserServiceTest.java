package com.campaign.user.mangement.usermanagement.service;

import com.campaign.user.mangement.usermanagement.entity.User;
import com.campaign.user.mangement.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

   // @Test
    void getAllUsers(@Autowired MongoTemplate mongoTemplate) {
        User expected = new User("Jones","9800012000" );
        mongoTemplate.save(expected, "Users");
        /*List<User> users = mongoTemplate.findAll(User.class, "Users");
        User actual = users.get(users.size());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());*/
    }
}
