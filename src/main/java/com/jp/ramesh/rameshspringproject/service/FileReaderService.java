package com.jp.ramesh.rameshspringproject.service;

import com.jp.ramesh.rameshspringproject.model.UserDetails;

import java.util.List;

public interface FileReaderService {
    List<UserDetails> readDataFromCsv();
}
