package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.repository.KichCoRepository;
import com.example.website_sportclothings_ph25462.service.KichCoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
//@RestController
//@RequiredArgsConstructor
//@Slf4j
public class KichCoController {
    @Autowired
    KichCoRepository kcr;
    @Autowired
    KichCoService kichCoService;

    //    public Map<Integer, String> getDsTrangThai() {
//        Map<Integer, String> dsTrangThai = new HashMap<>();
//        dsTrangThai.put(0, " hoạt động");
//        dsTrangThai.put(1, " không Hoạt động");
//        return dsTrangThai;
//    }
//    @GetMapping("/kich-co")
//    public ResponseEntity<?> index() {
////        Pageable pageable = PageRequest.of(page, 5);
////        Page<ChatLieu> list = this.chatLieuRepo.findAll(pageable);
////        model.addAttribute("list", list);
////        model.addAttribute("searchForm", new SearchForm());
//        return ResponseEntity.ok(kcr.findAll());
//    }

    @GetMapping("/kich-co/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", kichCoService.getAll());
        model.addAttribute("kc", new KichCo());
        model.addAttribute("view", "../kick_co/index.jsp");
        return "/kich_co/index";
    }

    @GetMapping("/kich-co/view-update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("kichCo", kichCoService.update(id));
        return "/kich_co/view_update";
    }

    @PostMapping("/kich-co/view-update/{id}")
    public String update(
            @PathVariable Long id, Model model, @Valid @ModelAttribute("kichCo") KichCo kichCo, BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/kich_co/view_update.jsp");
            return "/kich_co/view_update";
        }
        kichCo.setId(id);
        kichCoService.add(kichCo);
        return "redirect:/kich-co/hien-thi";
    }

    @GetMapping("/kich-co/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("kichCo") KichCo kichCo) {
        return ("/kich_co/add");
    }
    @PostMapping("/add/kích-co")
    public ResponseEntity<?> add(@RequestBody @Valid KichCo kichCo) {
        return ResponseEntity.ok(kcr.save(kichCo));
    }
    @PostMapping("/kich-co/hien-thi-add")
    public String add(Model model, @Valid @ModelAttribute("kichCo") KichCo kichCo, BindingResult result) {
        Boolean hasError = result.hasErrors();
        KichCo product = kichCoService.getOne(kichCo.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("makcError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "/kich_co/add.jsp");
            return "/kich_co/add";
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/kich_co/add.jsp");
            return "/kich_co/add";
        }
        kichCoService.add(kichCo);
        return "redirect:/kich-co/hien-thi";
    }

    @GetMapping("/kich-co/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        kichCoService.remove(id);
        return "redirect:/kich-co/hien-thi";
    }
}
