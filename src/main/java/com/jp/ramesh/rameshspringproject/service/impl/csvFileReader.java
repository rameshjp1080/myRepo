package com.jp.ramesh.rameshspringproject.service.impl;


import com.jp.ramesh.rameshspringproject.model.UserDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvFileReader {

    public List<UserDetails> getMyUserFromInputFile(String[] args) {
        String csvFile = "C:\\Ramesh\\workspace\\ramesh-spring-project\\src\\main\\java\\com\\jp\\ramesh\\rameshspringproject\\countries.csv";
        String line = "";
        String cvsSplitBy = ",";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                int i = 1;
                // use comma as separator
                String[] user = line.split(cvsSplitBy);
                List<UserDetails> userInputList = new ArrayList<>();
                UserDetails[] listUser i] =new UserDetails(user[0], user[1]);
                userInputList.add(listUser[i]);
                //System.out.println("User [code= " + user[0] + " , name=" + user[1] + "]");
                i = i + 1;
                return userInputList;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
