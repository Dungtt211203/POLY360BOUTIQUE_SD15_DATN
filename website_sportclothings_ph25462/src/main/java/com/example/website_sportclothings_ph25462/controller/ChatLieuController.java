package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.repository.ChatLieuRepository;
import com.example.website_sportclothings_ph25462.repository.KichCoRepository;
import com.example.website_sportclothings_ph25462.service.ChatLieuService;
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
public class ChatLieuController {
    @Autowired
    ChatLieuRepository clr;
    @Autowired
    ChatLieuService chatLieuService;

    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(0, " hoạt động");
        dsTrangThai.put(1, " không Hoạt động");
        return dsTrangThai;
    }

    @GetMapping("/chat-lieu/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", chatLieuService.getAll());
        model.addAttribute("cl", new ChatLieu());
        model.addAttribute("view", "../chat_lieu/index.jsp");
        return "/chat_lieu/index";
    }

    @GetMapping("/chat-lieu/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("chatLieu") KichCo kichCo) {
        return ("/chat_lieu/add");
    }

    @PostMapping("/chat-lieu/hien-thi-add")
    public String add(@ModelAttribute("chatLieu") ChatLieu chatLieu) {
        chatLieuService.add(chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("/chat-lieu/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        chatLieuService.remove(id);
        return "redirect:/chat-lieu/hien-thi";
    }
}
