package com.example.danae.watopia.model;

import java.util.Arrays;
import java.util.List;

public class RegisteredUsers {
    public static List<String> LegalStandings = Arrays.asList("User",
            "Worker", "Admin", "Manager");
    private static int next_ID = 0;
    private final int id;
    private final String email;
    private final String password;
    private final String name;
    private final Standing standing;
    public String getName() {
        return name;
    }
    public String getPassword() {return password;}
// --Commented out by Inspection START (4/11/2017 1:40 AM):
// --Commented out by Inspection START (4/11/2017 1:40 AM):
// --Commented out by Inspection START (4/11/2017 1:40 AM):
//////    public int getId() {
//////        return id;
//////    }
////// --Commented out by Inspection STOP (4/11/2017 1:40 AM)
////    public void setId(int id) {
////        this.id = id;
////    }
//// --Commented out by Inspection STOP (4/11/2017 1:40 AM)
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (4/11/2017 1:40 AM)
    public String getEmail() {
        return email;
    }
// --Commented out by Inspection START (4/11/2017 1:41 AM):
// --Commented out by Inspection START (4/11/2017 1:41 AM):
////    public void setEmail(String email) {
////        this.email = email;
////    }
//// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
//    public void setPassword(String password) {
//        this.password = password;
//    }
// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
    public Standing getStanding() {
        return standing;
    }
// --Commented out by Inspection START (4/11/2017 1:41 AM):
//    public void setStanding(Standing standing) {
//        this.standing = standing;
//    }
// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
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
