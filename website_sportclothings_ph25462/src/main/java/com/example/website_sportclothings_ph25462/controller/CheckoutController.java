package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.repository.DiaChiRepository;
import com.example.website_sportclothings_ph25462.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CheckoutController {

//    @Autowired
//    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private DiaChiRepository diaChiRepository;

    @GetMapping("/showCheckout")
    public String showCheckout(Model model) {

        try {
            model.addAttribute("diaChiList", diaChiRepository.findAll()); // phải hiển thị địa chỉ theo khách hàng dang đăng nhập.
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "/checkout/checkout";
    }

}
