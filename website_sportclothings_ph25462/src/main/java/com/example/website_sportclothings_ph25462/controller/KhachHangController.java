package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.repository.KhachHangRepository;
import com.example.website_sportclothings_ph25462.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class KhachHangController {
    @Autowired
    KhachHangRepository khr;
    @Autowired
    KhachHangService khachHangService;



    @GetMapping("/khach-hang/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", khachHangService.getAll());
        model.addAttribute("kh", new KhachHang());
        model.addAttribute("view", "../khach_hang/index.jsp");
        return "/khach_hang/index";
    }

    @GetMapping("/khach-hang/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("khachHang") KhachHang khachHang) {
        return ("/khach_hang/add");
    }

    @GetMapping("/khach-hang/view-update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("khachHang", khachHangService.update(id));
        return "/khach_hang/view_update";
    }

    @PostMapping("/khach-hang/view-update/{id}")
    public String update(
            @PathVariable Long id, Model model, @Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/khach_hang/view_update.jsp");
            return "/khach_hang/view_update";
        }
        khachHang.setId(id);
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/khach-hang/hien-thi-add")
    public String add(Model model, @Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result) {
        Boolean hasError = result.hasErrors();
        KhachHang product = khachHangService.getOne(khachHang.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("makhError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "/khach_hang/add.jsp");
            return "/khach_hang/add";
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/khach_hang/add.jsp");
            return "/khach_hang/add";
        }
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        khachHangService.remove(id);
        return "redirect:/khach-hang/hien-thi";
    }

//    @GetMapping("/search")
//    public String search(Model model, @ModelAttribute("key") String key, @RequestParam(defaultValue = "0", name = "page") Integer page) {
//        Pageable pageable = PageRequest.of(page, 5);
//        Page<KhachHang> list = khachHangService.search(key, pageable);
//        model.addAttribute("list", list);
//        return "redirect:/khach-hang/hien-thi";
//    }
}
