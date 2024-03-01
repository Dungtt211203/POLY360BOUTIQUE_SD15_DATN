package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.repository.SanPhamRepository;
import com.example.website_sportclothings_ph25462.service.Impl.SanPhamServiceImpl;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import jakarta.validation.Valid;
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
//@Slf4j
public class SanPhamController {
    @Autowired
    SanPhamRepository spr;
    @Autowired
    SanPhamService sanPhamService;

    //    public Map<Integer, String> getDsTrangThai() {
//        Map<Integer, String> dsTrangThai = new HashMap<>();
//        dsTrangThai.put(0, " hoạt động");
//        dsTrangThai.put(1, " không Hoạt động");
//        return dsTrangThai;
//    }
//    @GetMapping("/san-pham")
//    public ResponseEntity<?> index() {
////        Pageable pageable = PageRequest.of(page, 5);
////        Page<ChatLieu> list = this.chatLieuRepo.findAll(pageable);
////        model.addAttribute("list", list);
////        model.addAttribute("searchForm", new SearchForm());
//        return ResponseEntity.ok(spr.findAll());
//    }

    @PostMapping("/add/san-pham")
    public ResponseEntity<?> add(@RequestBody @Valid SanPham sanPham) {
        return ResponseEntity.ok(spr.save(sanPham));
    }

    @GetMapping("/san-pham/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", sanPhamService.getAll());
        model.addAttribute("sp", new SanPham());
        model.addAttribute("view", "../webapp/WEB-INF/view/san_pham/index.jsp");
        return "/san_pham/index";
    }

    @GetMapping("/san-pham/view-update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("sanPham", sanPhamService.update(id));
        return "/san_pham/view_update";
    }

    @PostMapping("/san-pham/view-update/{id}")
    public String update(
            @PathVariable Long id, Model model, @Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/san_pham/view_update.jsp");
            return "/san_pham/view_update";
        }
        sanPham.setId(id);
        sanPhamService.add(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("sanPham") SanPham sanPham) {
        return ("/san_pham/add");
    }

    @PostMapping("/san-pham/hien-thi-add")
    public String add(Model model, @Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result) {
        Boolean hasError = result.hasErrors();
        SanPham product = sanPhamService.getOne(sanPham.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("maclError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "/san_pham/add.jsp");
            return "/san_pham/add";
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/san_pham/add.jsp");
            return "/san_pham/add";
        }
        sanPhamService.add(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        sanPhamService.remove(id);
        return "redirect:/san-pham/hien-thi";
    }

}
