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

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/authorize")
public class AuthenticationController {

    @Autowired
    private AuthorizationService authorizationService;
    private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/user")
    public ResponseEntity<?> authorizeUser(@RequestBody User user) {
        try {
            Map<String,Object> res = new HashMap<>();
            User existingUser = authorizationService.authorizeUser(user);
            if (existingUser!=null) {
                res.put("status",true);
                res.put("data",existingUser);
                logger.info("User: " + user.getEmail() + " authorized successfully");
            } else {
                res.put("status",false);
                res.put("data","User not authorized");
                logger.info("User: " +user.getEmail()+ " not authorized");
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception in method authorizeUser() " + e.getMessage());
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<?> authorizeAdmin(@RequestBody Admin admin) {
        try {
            Map<String,Object> res = new HashMap<>();
            Admin existingAdmin = authorizationService.authorizeAdmin(admin);
            if(existingAdmin!=null) {
                res.put("status", true);
                res.put("data",existingAdmin);
                logger.info("Admin: " + admin.getFirstName() + " authorized successfully");
            } else {
                res.put("status",false);
                res.put("data","Not Authorized");
                logger.info("Admin: " + admin.getEmail() + " not authorized");
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception in method authorizeAdmin() " + e.getMessage());
        }
        return null;
    }


}
