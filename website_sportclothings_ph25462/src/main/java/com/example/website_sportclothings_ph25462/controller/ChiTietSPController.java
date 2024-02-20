package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import com.example.website_sportclothings_ph25462.repository.ChiTietSPRepository;
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
    private ChiTietSPRepository repository;
    @GetMapping("/hien-thi")
    public String view(Model model) {
        model.addAttribute("list", repository.findAll());
        model.addAttribute("sp",new ChiTietSP());
        model.addAttribute("view", "../chitietsp/index.jsp");
        return "/chitietsp/index";
    }

    @PostMapping("/add")
    public String add(ChiTietSP chiTietSp, Model model) {
        model.addAttribute("sp",new ChiTietSP());
        repository.save(chiTietSp);
        return "redirect:/chitietsp/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") UUID id) {
        repository.deleteById(id);
        return "redirect:/chitietsp/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        ChiTietSP chiTietSp = repository.findById(id).orElse(null);
        model.addAttribute("sp",new ChiTietSP());
        model.addAttribute("chitietsp", chiTietSp);
        return "chitietsp/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("chitietsp") ChiTietSP chiTietSp, Model model) {
        model.addAttribute("sp",new ChiTietSP());
        repository.save(chiTietSp);
        return "redirect:/chitietsp/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable UUID id, Model model) {
        ChiTietSP chiTietSp = repository.findById(id).orElse(null);
        model.addAttribute("chitietsp", chiTietSp);
        return "chitietsp/detail";
    }
}


