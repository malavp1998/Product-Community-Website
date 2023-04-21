package com.nagarro.productCommunitySystem.repository;

import com.nagarro.productCommunitySystem.model.Admin;
import com.nagarro.productCommunitySystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findByEmail(String email);
}
