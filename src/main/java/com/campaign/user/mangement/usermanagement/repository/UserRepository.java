package com.campaign.user.mangement.usermanagement.repository;

import com.campaign.user.mangement.usermanagement.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
