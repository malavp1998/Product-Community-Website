package com.nagarro.productCommunitySystem.repository;

import com.nagarro.productCommunitySystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
