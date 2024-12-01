package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//@Data
public class UserDTO {
    @JsonProperty("Username")
    private String Username;
    @JsonProperty("Password")
    private String Password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
}
