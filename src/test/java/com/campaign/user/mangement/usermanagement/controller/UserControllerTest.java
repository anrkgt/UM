package com.campaign.user.mangement.usermanagement.controller;

import com.campaign.user.mangement.usermanagement.entity.User;
import com.campaign.user.mangement.usermanagement.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void createUserAPI() throws Exception {
        /*mockMvc.perform(MockMvcRequestBuilders.post("/CPM/user/createUser"))
        .andExpect(status().isOk());*/
    }

    @Test
    public void getUser() throws Exception {
        given(userService.getUserDetails(anyString()))
                .willReturn(new User("Jones"));

        mockMvc.perform(MockMvcRequestBuilders.get("/CPM/user/getUser/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Jones"));
                //.andExpect(jsonPath("phoneNumber").value("9800012000"));
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = Arrays.asList(
                new User("Jones","9800012000" ),
                new User("Bob","8800012000" ),
                new User("Charles","1800012000" )
        );

        given(userService.findAllUsers())
                .willReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/CPM/user/getAllUsers"))
                .andExpect(jsonPath("$", Matchers.hasSize(3))).andDo(print());
    }

}
