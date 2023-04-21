package com.nagarro.productCommunitySystem.service.impl;

import com.nagarro.productCommunitySystem.model.Admin;
import com.nagarro.productCommunitySystem.model.User;
import com.nagarro.productCommunitySystem.repository.AdminRepository;
import com.nagarro.productCommunitySystem.repository.UserRepository;
import com.nagarro.productCommunitySystem.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public User authorizeUser(User user) throws Exception {
        try {
            User existingUser = userRepository.findByEmail(user.getEmail());
            if (existingUser != null) {
                byte[] exitingPasswordByte = Base64.getDecoder().decode(existingUser.getPassword());
                String exitingPassword = new String(exitingPasswordByte);
                if (existingUser.getEmail().equals(user.getEmail().trim()) && exitingPassword.equals(user.getPassword().trim())) {
                    return existingUser;
                }
            }
            return null;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public Admin authorizeAdmin(Admin admin) throws Exception {
        try {
            Admin existingAdmin = adminRepository.findByEmail(admin.getEmail());
            if (existingAdmin != null) {
                byte[] exitingPasswordByte = Base64.getDecoder().decode(existingAdmin.getPassword());
                String exitingPassword = new String(exitingPasswordByte);
                if (existingAdmin.getEmail().equals(admin.getEmail().trim()) && exitingPassword.equals(admin.getPassword().trim())) {
                    return existingAdmin;
                }
            }
            return null;
        }
        catch (Exception e)
        {
            throw e;
        }
    }


}
