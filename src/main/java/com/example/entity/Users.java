package com.example.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Users {
    Long UserID;
    String Username;
    String Password;
    String Email;
    String Role;
    String Status;
    LocalDateTime CreatedAt;
}
