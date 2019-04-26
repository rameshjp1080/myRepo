package com.jp.ramesh.rameshspringproject.controller;

import com.jp.ramesh.rameshspringproject.model.UserDetails;
import com.jp.ramesh.rameshspringproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/v1/user/{userId}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable("userId") String userId) {

        try {
            UserDetails userDetails = userService.getUserById(userId);
            return new ResponseEntity<>(userDetails, HttpStatus.OK);

        } catch (Exception e) {
            log.error("Oops. There is an exception: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/api/v1/allUsers")
    public ResponseEntity<List<UserDetails>> getUserall() {
        try {
            List<UserDetails> allUserDetails = userService.getAllUserDetails();
            return new ResponseEntity<>(allUserDetails, HttpStatus.OK);

        } catch (Exception e) {
            log.error("Oops. There is an exception: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/api/v1/user")
    public ResponseEntity<List<UserDetails>> getUserListByIds(@RequestParam List<Long> ids) {
        try {
            log.info("userIds: {}", ids);
            List<UserDetails> allUserDetails = userService.getAllUserDetailsByIds(ids);
            log.info("allUserDetails: {}", allUserDetails);
            return new ResponseEntity<>(allUserDetails, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Oops. There is an exception: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/api/v1/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetails> addUser(@RequestBody UserDetails userDetails) {
        log.info("Adding User details : {}", userDetails);
        userService.addUser(userDetails);
        return new ResponseEntity<>(userDetails, HttpStatus.CREATED);
    }
}
