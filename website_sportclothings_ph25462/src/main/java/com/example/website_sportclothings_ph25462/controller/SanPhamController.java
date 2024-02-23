package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.repository.SanPhamRepository;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class SanPhamController {
    @Autowired
    SanPhamRepository spr;
    @Autowired
    SanPhamService sanPhamService;

    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(0, " hoạt động");
        dsTrangThai.put(1, " không Hoạt động");
        return dsTrangThai;
    }

    @GetMapping("/san-pham/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", sanPhamService.getAll());
        model.addAttribute("sp", new SanPham());
        model.addAttribute("view", "../san_pham/index.jsp");
        return "/san_pham/index";
    }

    @GetMapping("/san-pham/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("sanPham") SanPham sanPham) {
        return ("/san_pham/add");
    }

    @PostMapping("/san-pham/hien-thi-add")
    public String add(@ModelAttribute("sanPham") SanPham sanPham) {
        sanPhamService.add(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        sanPhamService.remove(id);
        return "redirect:/san-pham/hien-thi";
    }
}
