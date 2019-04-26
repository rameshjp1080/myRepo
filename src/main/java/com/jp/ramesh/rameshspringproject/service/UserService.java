package com.jp.ramesh.rameshspringproject.service;

import com.jp.ramesh.rameshspringproject.model.UserDetails;

import java.util.List;

public interface UserService {
    UserDetails getUserById(String userId);

    List<UserDetails> getAllUserDetails();

    List<UserDetails> getAllUserDetailsByIds(List<Long> userIds);

    List<UserDetails> getAllUserFromInputFile(List<Long> user);

    UserDetails addUser(UserDetails userDetail);
}
