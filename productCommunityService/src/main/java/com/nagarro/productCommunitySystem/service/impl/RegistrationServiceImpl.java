package com.nagarro.productCommunitySystem.service.impl;

import com.nagarro.productCommunitySystem.model.Admin;
import com.nagarro.productCommunitySystem.model.User;
import com.nagarro.productCommunitySystem.repository.AdminRepository;
import com.nagarro.productCommunitySystem.repository.UserRepository;
import com.nagarro.productCommunitySystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean registerNewUser(User user) throws Exception {
        try {
            User exitingUser = userRepository.findByEmail(user.getEmail());
            if (exitingUser == null) {
                user.setEmail(user.getEmail().trim());
                user.setFirstName(user.getFirstName().trim());
                user.setLastName(user.getLastName().trim());
                user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
                userRepository.save(user);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean registerNewAdmin(Admin admin) throws Exception {
        try {
            Admin exitingAdmin = adminRepository.findByEmail(admin.getEmail());
            if (exitingAdmin == null) {
                admin.setEmail(admin.getEmail().trim());
                admin.setFirstName(admin.getFirstName().trim());
                admin.setLastName(admin.getLastName().trim());
                admin.setPassword(Base64.getEncoder().encodeToString(admin.getPassword().getBytes()));
                adminRepository.save(admin);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int getUserCount() throws Exception {
        try {
            return userRepository.findAll().size();
        } catch (Exception e) {
            throw e;
        }
    }


}
