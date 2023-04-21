package com.nagarro.productCommunitySystem.service;

import com.nagarro.productCommunitySystem.model.Admin;
import com.nagarro.productCommunitySystem.model.User;

public interface RegistrationService {

    boolean registerNewUser(User user) throws Exception;
    boolean registerNewAdmin(Admin admin) throws Exception;

    int getUserCount() throws Exception;

}
