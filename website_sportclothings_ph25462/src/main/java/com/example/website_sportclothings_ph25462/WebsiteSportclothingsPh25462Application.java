package com.example.website_sportclothings_ph25462;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebsiteSportclothingsPh25462Application {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteSportclothingsPh25462Application.class, args);

        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        System.out.println(enc.encode("123"));
    }

}
