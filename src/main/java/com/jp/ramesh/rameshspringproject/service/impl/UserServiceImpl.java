package com.jp.ramesh.rameshspringproject.service.impl;

import com.jp.ramesh.rameshspringproject.model.UserDetails;
import com.jp.ramesh.rameshspringproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserDetails> getAllUserDetails() {

        log.info("getUseall - I am getting complete user list");
        //List<EmployeeList> userList = new ArrayList<EmployeeList>();
        List<UserDetails> userallDetailList = new ArrayList<>();
        UserDetails l1 = new UserDetails(101, "Ramesh");
        UserDetails l2 = new UserDetails(102, "Renga");
        UserDetails l3 = new UserDetails(103, "Ragav");
        userallDetailList.add(l1);
        userallDetailList.add(l2);
        userallDetailList.add(l3);
        return userallDetailList;
    }

    @Override
    public List<UserDetails> getAllUserDetailsByIds(List<Long> userIds) {

        log.info("getAllUserDetailsByIds - I am getting user list input: {}", userIds);
        List<UserDetails> allUserDetails = getAllUserDetails();
        log.info("getAllUserDetailsByIds - I am getting user list allUserDetails: {}", allUserDetails);

        List<UserDetails> filteredUserDetails = allUserDetails.stream()
                .filter(userDetails -> userIds.contains(new Long(userDetails.getId())))
                .collect(Collectors.toList());
        log.info("filteredUserDetails: {}", filteredUserDetails);
        return filteredUserDetails;
    }
}