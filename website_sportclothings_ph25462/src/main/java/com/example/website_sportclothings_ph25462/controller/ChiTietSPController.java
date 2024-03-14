package com.example.website_sportclothings_ph25462.controller;


import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
@Controller
@RequestMapping("/chitietsp")
public class ChiTietSPController {
    @Autowired
    private ChiTietSanPhamRepository repository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private KichCoRepository kichCoRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private ChatLieuRepository chatLieuRepository;
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;
    @GetMapping("/hien-thi")
    public String view(Model model) {
        model.addAttribute("list", repository.findAll());
        model.addAttribute("sp",new ChiTietSanPham());
        model.addAttribute("view", "../chitietsp/index.jsp");
        model.addAttribute("sanPham", sanPhamRepository.findAll());
        model.addAttribute("kichCo", kichCoRepository.findAll());
        model.addAttribute("mauSac", mauSacRepository.findAll());
        model.addAttribute("chatLieu", chatLieuRepository.findAll());
        model.addAttribute("thuongHieu", thuongHieuRepository.findAll());
        return "/chitietsp/index";
    }
    @GetMapping("/viewadd")
    public String hienThiAdd(@ModelAttribute("ctsp") ChiTietSanPham chiTietSP, Model model) {
        //   model.addAttribute("view", "../chitietsp/index.jsp");
        model.addAttribute("sanPham", sanPhamRepository.findAll());
        model.addAttribute("kichCo", kichCoRepository.findAll());
        model.addAttribute("mauSac", mauSacRepository.findAll());
        model.addAttribute("chatLieu", chatLieuRepository.findAll());
        model.addAttribute("thuongHieu", thuongHieuRepository.findAll());
        model.addAttribute("ctsp",new ChiTietSanPham());
        return "chitietsp/add";
    }
    @PostMapping("/add")
    public String add(ChiTietSanPham chiTietSp, Model model) {
        model.addAttribute("sp",new ChiTietSanPham());
        repository.save(chiTietSp);
        return "redirect:/chitietsp/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        repository.deleteById(id);
        return "redirect:/chitietsp/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable Long id, Model model) {
        ChiTietSanPham chiTietSp = repository.findById(id).orElse(null);
        //   model.addAttribute("view", "../chitietsp/index.jsp");
        model.addAttribute("sanPham", sanPhamRepository.findAll());
        model.addAttribute("kichCo", kichCoRepository.findAll());
        model.addAttribute("mauSac", mauSacRepository.findAll());
        model.addAttribute("chatLieu", chatLieuRepository.findAll());
        model.addAttribute("thuongHieu", thuongHieuRepository.findAll());
        model.addAttribute("sp",new ChiTietSanPham());
        model.addAttribute("chitietsp", chiTietSp);
        return "chitietsp/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,@ModelAttribute("chitietsp") ChiTietSanPham chiTietSp, Model model) {
        model.addAttribute("sp",new ChiTietSanPham());
        chiTietSp.setId(id);
        repository.save(chiTietSp);
        return "redirect:/chitietsp/hien-thi";
    }

}


