package com.example.demo.jpa.jpademo.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testConstructor() {
        User actualUser = new User(new com.example.demo.jpa.jpademo.entity.User());
        assertNull(actualUser.getLName());
        assertEquals(0, actualUser.getAge());
        assertNull(actualUser.getFName());
    }

    @Test
    public void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date Time = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        com.example.demo.jpa.jpademo.entity.User user = new com.example.demo.jpa.jpademo.entity.User();
        user.setTime(Time);
        User actualUser = new User(user);
        assertNull(actualUser.getLName());
        assertEquals(0, actualUser.getAge());
        assertNull(actualUser.getFName());
    }

    @Test
    public void testSetFName() {
        User user = new User();
        user.setFName("FName");
        assertEquals("FName", user.getFName());
    }

    @Test
    public void testSetLName() {
        User user = new User();
        user.setLName("LName");
        assertEquals("LName", user.getLName());
    }

    @Test
    public void testCanEqual() {
        assertFalse((new User()).canEqual("other"));
    }
}

