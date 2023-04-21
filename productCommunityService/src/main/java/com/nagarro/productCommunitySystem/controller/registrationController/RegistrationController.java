package com.nagarro.productCommunitySystem.controller.registrationController;

import com.nagarro.productCommunitySystem.model.Admin;
import com.nagarro.productCommunitySystem.model.User;
import com.nagarro.productCommunitySystem.service.RegistrationService;
import lombok.extern.flogger.Flogger;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @PostMapping("/user")
    public ResponseEntity<Boolean> registerUser(@RequestBody User user) {
        try {
            boolean isUserRegistered = registrationService.registerNewUser(user);
            if (isUserRegistered) {
                logger.info("New User: " + user.getFirstName() + " " + user.getLastName() + " registered");
                return new ResponseEntity<>(true, HttpStatus.CREATED);
            } else {
                logger.info("User with email " + user.getEmail() + "already exits");
                return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            logger.error("Exception in method registerUser() " + e);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/admin")
    public ResponseEntity<Boolean> registerAdmin(@RequestBody Admin admin) {
        try {
            boolean isUserRegistered = registrationService.registerNewAdmin(admin);
            if (isUserRegistered) {
                logger.info("New Admin: " + admin.getFirstName() + " " + admin.getLastName() + " registered");
                return new ResponseEntity<>(true, HttpStatus.CREATED);
            } else {
                logger.info("Admin with email " + admin.getEmail() + "already exits");
                return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            logger.error("Exception in method registerAdmin() " + e);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/user/count")
    public ResponseEntity<Integer> getUserCount() {
        try {
            return new ResponseEntity<>(registrationService.getUserCount(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception in method getUserCount() " + e);
        }
        return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
    }


}
