package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/poly360boutique")


public class DangKyController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/dang-ky")
    public String hienThi() {

        return "/login/dangky";
    }


    @PostMapping("/dang-ky/add")
    public String add(
            @RequestParam("emailRegis") String email,
            @RequestParam("userRegis") String tenTK,
            @RequestParam("passwordRegis") String matKhau

    ) {

        TaiKhoan taiKhoan = TaiKhoan.builder()
                .email(email)
                .tenTK(tenTK)
                .matKhau(matKhau)
                .build();

        taiKhoanService.add(taiKhoan);

        return "redirect:/poly360boutique/dang-ky";

    }


}
