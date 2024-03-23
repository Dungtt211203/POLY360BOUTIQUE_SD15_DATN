package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.repository.KhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.service.KhuyenMaiService;
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
@RequestMapping("/admin")
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @Autowired
    KhuyenMaiService khuyenMaiService;

    @GetMapping("/khuyen-mai/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int km) {
        Pageable pageable = PageRequest.of(km, 5);
        Page<KhuyenMai> page = khuyenMaiService.getAll(pageable);
        model.addAttribute("load", khuyenMaiService.getAll());
        model.addAttribute("km", new KhuyenMai());
        model.addAttribute("page", page);
        model.addAttribute("view", "../khuyen_mai/chinh-sach.jsp");
        return "/khuyen_mai/index";
    }

    @GetMapping("/khuyen-mai/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("khuyenMai") KhuyenMai khuyenMai, Model model) {
        model.addAttribute("view", "../khuyen_mai/chinh-sach.jsp");
        return "/khuyen_mai/add";
    }

    @PostMapping("/khuyen-mai/hien-thi-add")
    public String add(Model model, @Valid @ModelAttribute("khuyenMai") KhuyenMai khuyenMai, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/khuyen_mai/add.jsp");
            return "/khuyen_mai/add";

        }
        khuyenMaiService.add(khuyenMai);
        return "redirect:/admin/khuyen-mai/hien-thi";
    }

    @GetMapping("/khuyen-mai/view-update/{id}")
    public String hienThiUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("khuyenMai", khuyenMaiService.update(id));
        return "/khuyen_mai/view_update";
    }

    @PostMapping("/khuyen-mai/view-update/{id}")
    public String update(@PathVariable Long id, Model model, @Valid @ModelAttribute("khuyenMai") KhuyenMai khuyenMai, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/khuyen_mai/view_update.jsp");
            return "/khuyen_mai/view_update";

        }
        khuyenMai.setId(id);
        khuyenMaiService.add(khuyenMai);
        return "redirect:/admin/khuyen-mai/hien-thi";
    }

    @GetMapping("/khuyen-mai/remove/{id}")
    public String delete(@PathVariable("id") Long id) {
        khuyenMaiService.remove(id);
        return "redirect:/admin/khuyen-mai/hien-thi";
    }
}
