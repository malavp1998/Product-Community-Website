package com.nagarro.productCommunitySystem.controller.authenticationController;

import com.nagarro.productCommunitySystem.model.Admin;
import com.nagarro.productCommunitySystem.model.User;
import com.nagarro.productCommunitySystem.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private AuthorizationService authorizationService;
    private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/user/authorize")
    public ResponseEntity<User> authorizeUser(@RequestBody User user) {
        try {
            User existingUser = authorizationService.authorizeUser(user);
            if (existingUser!=null) {
                logger.info("User: " + user.getEmail() + " authorized successfully");
                return new ResponseEntity<>(existingUser, HttpStatus.FOUND);
            } else {
                logger.info("User: " +user.getEmail()+ " not authorized");
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Exception in method authorizeUser() " + e.getMessage());
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/admin/authorize")
    public ResponseEntity<Admin> authorizeAdmin(@RequestBody Admin admin) {
        try {
            Admin existingAdmin = authorizationService.authorizeAdmin(admin);
            if (existingAdmin!=null) {
                logger.info("Admin: " + admin.getFirstName() + " authorized successfully");
                return new ResponseEntity<>(existingAdmin, HttpStatus.FOUND);
            } else {
                logger.info("Admin: " + admin.getEmail() + " not authorized");
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Exception in method authorizeAdmin() " + e.getMessage());
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }


}
