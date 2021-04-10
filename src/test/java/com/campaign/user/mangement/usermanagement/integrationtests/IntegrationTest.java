package com.campaign.user.mangement.usermanagement.integrationtests;

import com.campaign.user.mangement.usermanagement.entity.User;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getUser() {
       /* ResponseEntity<User> responseEntity = testRestTemplate.getForEntity("/CPM/user/getAllUsers", User.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getName()).isEqualTo("Jones");
        assertThat(responseEntity.getBody().getPhoneNumber()).isEqualTo("9800012000");*/

    }
}
