package com.jp.ramesh.rameshspringproject.service.impl;

import com.jp.ramesh.rameshspringproject.model.UserDetails;
import com.jp.ramesh.rameshspringproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public UserDetails getUserById(String userId) {
        log.info("UserServiceImpl - getUserById - I am getting the user");
        UserDetails userDetails = new UserDetails();
        userDetails.setId(Integer.parseInt(userId));
        userDetails.setName("Ramesh");
        log.info("UserServiceImpl - getUserById userDetails: {}", userDetails);
        return userDetails;
    }

    public UserDetails getUserall() {

        log.info("getUseall - I am getting complete user list");
        //List<EmployeeList> userList = new ArrayList<EmployeeList>();
        UserDetails userallDetails = new UserDetails();
        UserDetails l1 = new UserDetails(101, "Ramesh");
        UserDetails l2 = new UserDetails(102, "Renga");
        UserDetails l3 = new UserDetails(103, "Ragav");
        UserDetails.add(l1);
        return userallDetails;
    }
}