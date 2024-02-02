package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.repository.MauSacRepository;
import com.example.website_sportclothings_ph25462.service.Impl.MauSacServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("")
public class MauSacController {
    @Autowired
    MauSacRepository msr;
    @Autowired
    MauSacServiceImpl mss;
    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(0, " hoạt động");
        dsTrangThai.put(1, " không Hoạt động");
        return dsTrangThai;
    }
    @GetMapping("mau-sac/hien-thi")
    public String hien(Model model, @ModelAttribute("ms") MauSac mauSac, @RequestParam(defaultValue = "1") int page) {


//        if (page < 1) {
//            page = 1;
//        }
//        Pageable pageable = PageRequest.of(page - 1, 6);
//        Page<MauSac> pgg = this.mss.search(key, pageable);
//     model.addAttribute("list", pgg);
        model.addAttribute("ms", mauSac);
        model.addAttribute("view", "../mau_sac/index.jsp");
        return "/admin/index";
    }
}
