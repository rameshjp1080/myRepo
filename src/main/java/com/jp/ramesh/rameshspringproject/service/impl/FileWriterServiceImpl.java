package com.jp.ramesh.rameshspringproject.service.impl;

import com.jp.ramesh.rameshspringproject.model.UserDetails;
import com.jp.ramesh.rameshspringproject.service.FileWriterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeDataInFiles(UserDetails userDetails) {
        String FILENAME = "C:\\Ramesh\\workspace\\MyData\\UserRecords.csv";
        try {
            log.info("Start Writing files");
            File file = new File(FILENAME);
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));
            log.info("Record amended to the file{}", FILENAME);
            out.append(Integer.toString(userDetails.getId()));
            out.append(',');
            out.append(userDetails.getName());
            out.append('\n');
            out.close();
            log.info("File created successfully");
        } catch (IOException e) {
            log.error("Error while writing user details exception: {}", e);
            throw new RuntimeException("Error in Writing data");
        }
    }
}
