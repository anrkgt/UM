package com.campaign.user.mangement.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserUpdateRequestDTO {
    @Pattern(regexp = "^\\d{10}$", message = "Please enter valid Phone number with 10 digits")
    private String phoneNumber;
    @Email()
    private String email;
    private int age;
    private String address;
    private String state;
}
