package com.example.website_sportclothings_ph25462.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoLocController {
    @GetMapping("/boloc")
    public String hienThi(){
        return "boloc";
    }
}
