package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.repository.ChatLieuRepository;
import com.example.website_sportclothings_ph25462.service.ChatLieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
public class ChatLieuController {
    @Autowired
    ChatLieuRepository clr;
    @Autowired
    ChatLieuService chatLieuService;

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
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("chatLieu", chatLieuService.update(id));
        return "/chat_lieu/view_update";
    }

    @PostMapping("/chat-lieu/view-update/{id}")
    public String update(
            @PathVariable Long id, @ModelAttribute("chatLieu") ChatLieu chatLieu
    ) {
        chatLieu.setId(id);
        chatLieuService.add(chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }

    @PostMapping("/chat-lieu/hien-thi-add")
    public String add(Model model,@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu,  BindingResult result) {
        Boolean hasError = result.hasErrors();
        ChatLieu product = chatLieuService.getOne(chatLieu.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("maclError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "/chat_lieu/add.jsp");
            return "/chat_lieu/add";
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/chat_lieu/add.jsp");
            return "/chat_lieu/add";
        }
        chatLieuService.add(chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("/chat-lieu/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        chatLieuService.remove(id);
        return "redirect:/chat-lieu/hien-thi";
    }

//    @GetMapping("/search")
//    public String search(Model model, @ModelAttribute("key") String key, @RequestParam(defaultValue = "0", name = "page") Integer page) {
//        Pageable pageable = PageRequest.of(page, 5);
//        Page<ChatLieu> list = chatLieuService.search(key, pageable);
//        model.addAttribute("list", list);
//        return "redirect:/chat-lieu/hien-thi";
//    }
}
