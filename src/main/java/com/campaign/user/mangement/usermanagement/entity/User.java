package com.campaign.user.mangement.usermanagement.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Users")
public class User {
    @Schema(description = "Unique identifier for User", required = true)
    @Id
    private String id;

    @Schema(description = "Name of User", required = true)
    @NotNull(message = "Name cannot be empty")
    private String name;

    @Schema(description = "Phone number of User", required = true, maxLength = 10)
    @NotNull(message = "Phone number cannot be empty")
    private String phoneNumber;

    @Schema(description = "Email of User", required = true)
    @Email()
    private String email;

    @Schema(description = "Age of User", required = true)
    @NotNull
    @Min(value = 10, message = "Age should be more than 10")
    @Max(value = 100, message = "Age cannot be more than 100")
    private int age;

    @Schema(description = "Address of User", required = false)
    private String address;

    @Schema(description = "Status can be Active, Suspended, Terminated", required = true)
    @NotNull(message = "State cannot be empty")
    private String state;

    public User(String name, String phone){
        this.name = name;
        this.phoneNumber = phone;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String id, String name, String phoneNumber, String email, int age, String address, String state) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.address = address;
        this.state = state;
    }
}
