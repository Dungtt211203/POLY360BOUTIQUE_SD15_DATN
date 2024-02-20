package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.repository.MauSacRepository;
import com.example.website_sportclothings_ph25462.service.Impl.MauSacServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class MauSacController {
    @Autowired
    MauSacRepository msr;
    @Autowired
    MauSacServiceImpl mss;

//    public Map<Integer, String> getDsTrangThai() {
//        Map<Integer, String> dsTrangThai = new HashMap<>();
//        dsTrangThai.put(0, " hoạt động");
//        dsTrangThai.put(1, " không Hoạt động");
//        return dsTrangThai;
//    }

    @GetMapping("/mau-sac/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", mss.getAll());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("view", "../mau_sac/index.jsp");
        return "/mau_sac/index";
    }
    @GetMapping("/mau-sac/view-update/{id}")
    public String update(@PathVariable UUID id,
                         Model model){
        model.addAttribute("mauSac", mss.update(id));
        return "/mau_sac/view_update";
    }

    @GetMapping("/mau-sac/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("mauSac") MauSac mauSac) {
        return ("/mau_sac/add");
    }

    @PostMapping("/mau-sac/hien-thi-add")
    public String add(@ModelAttribute("mauSac") MauSac mauSac) {
        mss.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        mss.remove(id);
        return "redirect:/mau-sac/hien-thi";
    }
}
