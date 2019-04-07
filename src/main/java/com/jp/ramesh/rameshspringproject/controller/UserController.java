package com.jp.ramesh.rameshspringproject.controller;

import com.jp.ramesh.rameshspringproject.model.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @RequestMapping("/api/v1/user")
    public ResponseEntity<UserDetails> getUserById() {

        try {
            log.info("getUserById - I am getting the user");
            UserDetails userDetails = new UserDetails();
            userDetails.setId(1);
            userDetails.setName("Ramesh");
            log.info("getUserById userDetails: {}", userDetails);
            return new ResponseEntity<>(userDetails, HttpStatus.OK);

        } catch (Exception e) {
            log.error("Oops. There is an exception: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
