package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.KhachHangRepository;
import com.example.website_sportclothings_ph25462.security.LoginRequest;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DangNhapController {

    @Autowired
    private TaiKhoanDangDangNhap khachHangDangDangNhap;

    @Autowired
    KhachHangRepository khachHangRepository;


    @GetMapping("/login")
    public String login(@ModelAttribute("userLogin") LoginRequest loginRequest, Model model) {

        return "/login/dangnhap";
    }

//    @GetMapping("/login?error")
//    public String loginErr(Model model){
//        model.addAttribute("errorMessage","Sai TT đăng nhập");
//        return "redirect:/login";
//    }

    @ModelAttribute("principal")
    public TaiKhoan principal() {
        TaiKhoan taiKhoan = khachHangDangDangNhap.getCurrentNguoiDung();

        if (taiKhoan != null) {
            System.out.printf("KHvvvvvv: " + taiKhoan.getTenTK());
        }

        return taiKhoan;
    }


}
