package com.nagarro.productCommunitySystem.service;

import com.nagarro.productCommunitySystem.model.Admin;
import com.nagarro.productCommunitySystem.model.User;

public interface AuthorizationService {
    User authorizeUser(User user) throws Exception;
    Admin authorizeAdmin(Admin admin) throws Exception;
}
