package com.example.website_sportclothings_ph25462.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poly360boutique")
public class QuenMatKhauController {
    @GetMapping("/quen-mat-khau")
    public String index(){
        return ("/login/quenmatkhau");
    }
}
