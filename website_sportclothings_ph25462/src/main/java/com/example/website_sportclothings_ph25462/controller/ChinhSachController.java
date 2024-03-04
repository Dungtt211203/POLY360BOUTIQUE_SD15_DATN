package com.example.website_sportclothings_ph25462.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poly360boutique")
public class ChinhSachController {
    @GetMapping("/chinh-sach")
    public String index(){
        return ("/chinh_sach/index");
    }
}
