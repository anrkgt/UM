package com.campaign.user.mangement.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRequestDTO {
    @NotNull(message = "Name cannot be empty")
    private String name;
    private String phoneNumber;
    private String email;
    private int age;
    private String address;
    private String state;

}
