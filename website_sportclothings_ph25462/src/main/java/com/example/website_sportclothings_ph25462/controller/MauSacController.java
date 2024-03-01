package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.repository.MauSacRepository;
import com.example.website_sportclothings_ph25462.service.Impl.MauSacServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
//@RestController
//@Slf4j
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
    @GetMapping("/mau-sac")
    public ResponseEntity<?> index() {
//        Pageable pageable = PageRequest.of(page, 5);
//        Page<ChatLieu> list = this.chatLieuRepo.findAll(pageable);
//        model.addAttribute("list", list);
//        model.addAttribute("searchForm", new SearchForm());
        return ResponseEntity.ok(msr.findAll());
    }

    @GetMapping("/mau-sac/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", mss.getAll());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("view", "../mau_sac/index.jsp");
        return "/mau_sac/index";
    }

    @GetMapping("/mau-sac/view-update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("mauSac", mss.update(id));
        return "/mau_sac/view_update";
    }

    @PostMapping("/mau-sac/view-update/{id}")
    public String update(
            @PathVariable Long id, Model model, @Valid @ModelAttribute("mauSac") MauSac mauSac, BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/mau_sac/view_update.jsp");
            return "/mau_sac/view_update";
        }
        mauSac.setId(id);
        mss.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("mauSac") MauSac mauSac) {
        return ("/mau_sac/add");
    }

    @PostMapping("/add/mau-sac")
    public ResponseEntity<?> add(@RequestBody @Valid MauSac mauSac) {
        return ResponseEntity.ok(msr.save(mauSac));
    }

    @PostMapping("/mau-sac/hien-thi-add")
    public String add(Model model, @Valid @ModelAttribute("mauSac") MauSac mauSac, BindingResult result) {
        Boolean hasError = result.hasErrors();
        MauSac product = mss.getOne(mauSac.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("mamsError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "/mau_sac/add.jsp");
            return "/mau_sac/add";
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/mau_sac/add.jsp");
            return "/mau_sac/add";
        }
        mss.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        mss.remove(id);
        return "redirect:/mau-sac/hien-thi";
    }
}
