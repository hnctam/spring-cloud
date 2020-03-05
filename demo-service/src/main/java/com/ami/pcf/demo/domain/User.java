package com.ami.pcf.demo.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String description;
    private String dob;
}
