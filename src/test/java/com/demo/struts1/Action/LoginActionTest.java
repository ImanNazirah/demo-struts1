package com.demo.struts1.Action;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginActionTest {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Test
    void encryptPassword(){

        String inputPassword = "mypassword";
        String hashedPassword = encoder.encode(inputPassword);
        System.out.println("Your encrypted password : "+hashedPassword);

    }

    @Test
    void correctPassword(){

        String inputPassword = "password";
        String hashedPassword = encoder.encode("password");
        System.out.println("Checking ecrypted : "+hashedPassword);
        assertTrue(encoder.matches(inputPassword, hashedPassword));

    }

    @Test
    void incorrectPassword(){

        String inputPassword = "testing";
        String hashedPassword = encoder.encode("password");
        assertFalse(encoder.matches(inputPassword, hashedPassword));

    }

    @Test
    void testHashedPasswordFromDB(){

        String inputPassword = "mypassword";
        String passwordFromDB = "$2a$10$/DlV8jJGrPXqDeoFNi.IDOwpLGkHh1QicjhIvwpInCJMWv.SpfrRy";
        assertTrue(encoder.matches(inputPassword, passwordFromDB));

    }

}
