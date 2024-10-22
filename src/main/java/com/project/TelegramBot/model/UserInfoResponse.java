package com.project.TelegramBot.model;

import jakarta.persistence.Column;

import java.sql.Timestamp;

public class UserInfoResponse {


    private String firstName;

    private String lastName;

    private String username;

    private Timestamp registeredAt;

    public UserInfoResponse(String firstName, String lastName, String username, Timestamp registeredAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.registeredAt = registeredAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + '\n' +
                "Last name: " + lastName + '\n' +
                "Username: " + username + '\n' +
                "Registered at: " + registeredAt;
    }
}
