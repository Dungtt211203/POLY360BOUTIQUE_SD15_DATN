package com.example.website_sportclothings_ph25462.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poly360boutique")
public class ThuongHieuController {
    @GetMapping("/thuong-hieu-nike")
    public String hienThi(){
        return ("/thuong-hieu/thuong-hieu");
    }
}
