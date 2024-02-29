package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.dto.TaiKhoandto;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/poly360boutique")


public class DangKyController {

    @Autowired
    private TaiKhoanService taiKhoanService;


    @ModelAttribute("taikhoandto")
    public TaiKhoandto userResgistrationDto() {
        return new TaiKhoandto();
    }

    @ModelAttribute("userdto")
    public TaiKhoandto taikhoanResgistrationDto() {
        return new TaiKhoandto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "/login/dangky";
    }


    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("userdto") TaiKhoandto taiKhoandto) {
        if (taiKhoanService.checkTaikhoanbyEmail(taiKhoandto.getEmail())) {
            return "redirect:/registration?emailexist";
        }
        if (taiKhoandto.getMatKhau().equals(taiKhoandto.getCheckmatKhau()) == false) {
            return "redirect:/registration?checkpass";
        }
        taiKhoanService.add(taiKhoandto);
        return "redirect:/registration?success";
    }


}
