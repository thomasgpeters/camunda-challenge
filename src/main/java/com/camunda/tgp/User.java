package com.camunda.tgp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    // Class members
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
   
    public User( int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public User() {}

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    @JsonProperty("email")
    public String getEmail() {
        return this.email;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return this.firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return this.lastName;
    }

    @JsonProperty("avatar")
    public String getAvatar() {
        return this.avatar;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("first_name")
    public void serFirstName(String name) {
        this.firstName = name;
    }

    @JsonProperty("last_name")
    public void setLastName(String name) {
        this.lastName = name;
    }

    @JsonProperty("avatar")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String toString() {
        return "ID: " + Integer.toString(id) + " Name: " + this.getFirstName() + " " + getLastName() + " Email: " +  getEmail() + " Avatar: " + getAvatar();
    }
}
