package com.jp.ramesh.rameshspringproject.service.impl;

import com.jp.ramesh.rameshspringproject.service.WriteOutFileService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOutFileServiceImpl implements WriteOutFileService {
    @Override
    public BufferedWriter() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("outfilename"));
            out.write("aString");
            out.close();
            System.out.println("File created successfully");
        } catch (IOException e) {
        }
    }
}
