package com.jp.ramesh.rameshspringproject.service.impl;

import com.jp.ramesh.rameshspringproject.model.UserDetails;
import com.jp.ramesh.rameshspringproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private FileReaderServiceImpl fileReaderService;

    @Autowired
    private FileWriterServiceImpl fileWriterService;

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

        List<UserDetails> userDetailsList = fileReaderService.readDataFromCsv();
        log.info("UserServiceImpl - userDetailsList: {}", userDetailsList);
        return userDetailsList;
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

    @Override
    public List<UserDetails> getAllUserFromInputFile(List<Long> user) {
        return null;
    }

    @Override
    public UserDetails addUser(UserDetails userDetail) {
        log.info("Adding the user records: ");
        
        fileWriterService.writeDataInFiles(userDetail);
        return null;
    }
}