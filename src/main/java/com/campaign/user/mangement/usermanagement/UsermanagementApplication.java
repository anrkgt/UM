package com.campaign.user.mangement.usermanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsermanagementApplication {
	@Autowired
	ObjectMapper objectMapper;


	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}

}
