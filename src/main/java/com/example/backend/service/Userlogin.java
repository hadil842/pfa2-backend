package com.example.backend.service;


import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class Userlogin {

    private String accessname;
    private String password;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean authenticate(String username, String rawPassword){
        if (accessname.equals(username) && passwordEncoder.matches(rawPassword, password)) {
            return true;
        } else {
            if (!accessname.equals(username)) {
                System.out.println("error: username does not match.");
            }
            if (!passwordEncoder.matches(rawPassword, password)) {
                System.out.println("error: password does not match.");
            }
            return false;
        }
    }
}
