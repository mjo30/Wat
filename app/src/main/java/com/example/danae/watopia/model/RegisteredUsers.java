package com.example.danae.watopia.model;

import java.util.Arrays;
import java.util.List;
/**
 * Created by danae on 2/21/2017.
 */

public class RegisteredUsers {
    public static List<String> LegalStandings = Arrays.asList("User",
            "Worker", "Admin", "Manager");
    private static int next_ID = 0;
    public int id;
    private String email;
    private String password;
    private String name;
    private Standing standing;
    public String getName() {
        return name;
    }
    public String getPassword() {return password;}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Standing getStanding() {
        return standing;
    }
    public void setStanding(Standing standing) {
        this.standing = standing;
    }
    /**
     * constructor for RegisteredUsers
     */
    public RegisteredUsers(String name, String email, String password) {
        id = RegisteredUsers.next_ID++;
        this.name = name;
        this.email = email;
        this.password = password;
        standing = Standing.USER;
    }
    /**
     * constructor for RegisteredUsers
     */
    public RegisteredUsers(String name, String email,
                           String password, Standing standing) {
        id = RegisteredUsers.next_ID++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.standing = standing;
    }
    /**
     * returns a string in a sentence format with the user's name and user's email
     */
    public String toString() {
        return name+"'s email is: " + email + ".";
    }
}
