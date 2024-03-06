package com.example.website_sportclothings_ph25462.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CheckoutController {

    @GetMapping("/showCheckout")
    public String showCheckout(Model model) {

//        List<GioHangChiTiet> cart = gioHangChiTietService.getCartItems(); // ??

//        model.addAttribute("cartItems", cartItems);


        return "/checkout/checkout";
    }
}
