package com.example.danae.watopia.model;
import java.io.Serializable;

/**
 * Created by danae on 2/21/2017.
 */
/**
 * enum to represent various standings(user types)
 */
public enum Standing implements Serializable{
    USER("User"),
    WORKER("Worker"),
    MANAGER("Manager"),
    ADMIN("Admin");
    private String standing;
    Standing(String standing) {this.standing = standing;}
    public String toString() { return "" + standing;}
}
