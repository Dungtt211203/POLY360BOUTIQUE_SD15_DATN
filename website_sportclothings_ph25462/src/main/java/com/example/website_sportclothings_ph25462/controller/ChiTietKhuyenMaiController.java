package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.repository.ChiTietKhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChiTietKhuyenMaiController {
    @Autowired
    ChiTietKhuyenMaiRepository chiTietKhuyenMaiRepository;

    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @GetMapping("/chi-tiet-khuyen-mai/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listKmmct", chiTietKhuyenMaiRepository.findAll());
        model.addAttribute("view", "../chi_tiet_khuyen_mai/chinh-sach.jsp");
        model.addAttribute("chiTietSP", chiTietSanPhamRepository.findAll());
        model.addAttribute("khuyenMai", khuyenMaiRepository.findAll());

        return "/chi_tiet_khuyen_mai/index";
    }

    @GetMapping("/chi-tiet-khuyen-mai/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("ctkm") ChiTietKhuyenMai chiTietKhuyenMai, Model model) {
        model.addAttribute("listKmmct", chiTietKhuyenMaiRepository.findAll());
        model.addAttribute("view", "../chi_tiet_khuyen_mai/chinh-sach.jsp");
        model.addAttribute("chiTietSP", chiTietSanPhamRepository.findAll());
        model.addAttribute("khuyenMai", khuyenMaiRepository.findAll());
        model.addAttribute("ctkm", new ChiTietKhuyenMai());
        return "/chi_tiet_khuyen_mai/add";
    }

    @PostMapping("/chi-tiet-khuyen-mai/hien-thi-add")
    public String add(ChiTietKhuyenMai chiTietKhuyenMai, Model model) {
        model.addAttribute("ctkm", new ChiTietKhuyenMai());
        chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
        return "redirect:/chi-tiet-khuyen-mai/hien-thi";
    }


}
