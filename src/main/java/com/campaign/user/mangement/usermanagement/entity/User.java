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
    
    public User(){
    	super();
    }

    public User(String name) {
        this.name = name;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
