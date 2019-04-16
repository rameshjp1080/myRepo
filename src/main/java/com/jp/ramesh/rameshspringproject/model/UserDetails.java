package com.jp.ramesh.rameshspringproject.model;

import lombok.Data;

@Data
public class UserDetails {

    public UserDetails() {

    }

    public UserDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }
    private int id;
    private String name;
}
