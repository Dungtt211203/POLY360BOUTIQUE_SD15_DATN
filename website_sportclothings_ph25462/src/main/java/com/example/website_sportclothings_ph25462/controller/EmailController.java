package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.config.EmaiServiceImplConfig;
import com.example.website_sportclothings_ph25462.entity.Email;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {
    @Autowired
    private EmaiServiceImplConfig emaiServiceImplConfig;

    //    @PostMapping("")
//    public ResponseEntity<Void> sendEmail(@Valid @RequestBody Email email) {
//        emaiServiceImplConfig.sendEmail(email);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
    @GetMapping("/send-email")
    public String sendEmail() {
        emaiServiceImplConfig.sendSimpleMessage("recipient@example.com", "Subject", "Hello, this is a test email!");
        return "Email sent successfully!";
    }
}
