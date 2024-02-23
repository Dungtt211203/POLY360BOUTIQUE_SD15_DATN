package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.repository.KichCoRepository;
import com.example.website_sportclothings_ph25462.service.KichCoService;
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
public class KichCoController {
    @Autowired
    KichCoRepository kcr;
    @Autowired
    KichCoService kichCoService;

    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(0, " hoạt động");
        dsTrangThai.put(1, " không Hoạt động");
        return dsTrangThai;
    }

    @GetMapping("/kich-co/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", kichCoService.getAll());
        model.addAttribute("kc", new KichCo());
        model.addAttribute("view", "../kick_co/index.jsp");
        return "/kich_co/index";
    }

    @GetMapping("/kich-co/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("kichCo") KichCo kichCo) {
        return ("/kich_co/add");
    }

    @PostMapping("/kich-co/hien-thi-add")
    public String add(@ModelAttribute("kichCo") KichCo kichCo) {
        kichCoService.add(kichCo);
        return "redirect:/kich-co/hien-thi";
    }

    @GetMapping("/kich-co/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        kichCoService.remove(id);
        return "redirect:/kich-co/hien-thi";
    }
}
