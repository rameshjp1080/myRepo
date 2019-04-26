package com.jp.ramesh.rameshspringproject.service.impl;

import com.jp.ramesh.rameshspringproject.model.UserDetails;
import com.jp.ramesh.rameshspringproject.service.FileReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FileReaderServiceImpl implements FileReaderService {

    @Value("${UserDetails.csv.location}")
    private String csvFileLocation;

    @Override
    public List<UserDetails> readDataFromCsv() {

        log.info("CSV file location: {}", csvFileLocation);
        String line = "";
        String cvsSplitBy = ",";
        List<UserDetails> userDetailsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFileLocation))) {

            while ((line = br.readLine()) != null) {
                String[] rowArray = line.split(cvsSplitBy);
                userDetailsList.add(new UserDetails(Integer.parseInt(rowArray[0]), rowArray[1]));

            }

        } catch (IOException e) {
            log.error("Could not read from csv file exception: {} ", e);
        }

        return userDetailsList;
    }
}
