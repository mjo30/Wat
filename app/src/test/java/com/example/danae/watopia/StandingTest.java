package com.example.danae.watopia;

import com.example.danae.watopia.model.RegisteredUsers;
import com.example.danae.watopia.model.Standing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Minky on 2017-04-09.
 */

public class StandingTest {

    DataBaseHandler db;

    @Before
    public void setup() {
        db = Registration.getDb();
    }

    @Test
    public void testUserStanding() {
        RegisteredUsers user = new RegisteredUsers("Robert Waters",
                "waters@gatech.edu", "hello world", Standing.USER);
        db.addRegister(user);
        Assert.assertEquals(db.getKeyStanding("Robert Waters"), "User");
    }

    @Test
    public void testWorkerStanding() {
        RegisteredUsers user = new RegisteredUsers("Robert Waters",
                "waters@gatech.edu", "hello world", Standing.WORKER);
        db.addRegister(user);
        Assert.assertEquals(db.getKeyStanding("Robert Waters"), "Worker");
    }

    @Test
    public void testManagerStanding() {
        RegisteredUsers user = new RegisteredUsers("Robert Waters",
                "waters@gatech.edu", "hello world", Standing.MANAGER);
        db.addRegister(user);
        Assert.assertEquals(db.getKeyStanding("Robert Waters"), "Manager");
    }

    @Test
    public void testAdminStanding() {
        RegisteredUsers user = new RegisteredUsers("Robert Waters",
                "waters@gatech.edu", "hello world", Standing.ADMIN);
        db.addRegister(user);
        Assert.assertEquals(db.getKeyStanding("Robert Waters"), "Admin");
    }
}
