package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.repository.ChatLieuRepository;
import com.example.website_sportclothings_ph25462.repository.KichCoRepository;
import com.example.website_sportclothings_ph25462.service.ChatLieuService;
import com.example.website_sportclothings_ph25462.service.KichCoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class ChatLieuController {
    @Autowired
    ChatLieuRepository clr;
    @Autowired
    ChatLieuService chatLieuService;

//    public Map<Integer, String> getDsTrangThai() {
//        Map<Integer, String> dsTrangThai = new HashMap<>();
//        dsTrangThai.put(0, " hoạt động");
//        dsTrangThai.put(1, " không Hoạt động");
//        return dsTrangThai;
//    }

    @GetMapping("/chat-lieu/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", chatLieuService.getAll());
        model.addAttribute("cl", new ChatLieu());
        model.addAttribute("view", "../chat_lieu/index.jsp");
        return "/chat_lieu/index";
    }

    @GetMapping("/chat-lieu/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("chatLieu") ChatLieu chatLieu) {
        return ("/chat_lieu/add");
    }
    @GetMapping("/chat-lieu/view-update/{id}")
    public String update(@PathVariable UUID id,
                         Model model){
        model.addAttribute("chatLieu", chatLieuService.update(id));
        return "/chat_lieu/view_update";
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
