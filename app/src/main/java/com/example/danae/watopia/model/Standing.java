package com.example.danae.watopia.model;
import java.io.Serializable;

public enum Standing implements Serializable{
    USER("User"),
    WORKER("Worker"),
    MANAGER("Manager"),
    ADMIN("Admin");
    private final String standing;
    Standing(String standing) {this.standing = standing;}
    public String toString() { return "" + standing;}
}
