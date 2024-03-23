package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.service.ChiTietKhuyenMaiService;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import com.example.website_sportclothings_ph25462.service.KhuyenMaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ChiTietKhuyenMaiController {

    @Autowired
    ChiTietKhuyenMaiService chiTietKhuyenMaiService;

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    KhuyenMaiService khuyenMaiService;

    @GetMapping("/chi-tiet-khuyen-mai/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listKmmct", chiTietKhuyenMaiService.getAll());
        model.addAttribute("view", "../chi_tiet_khuyen_mai/index.jsp");
        model.addAttribute("chiTietSP", chiTietSanPhamService.getAll());
        model.addAttribute("khuyenMai", khuyenMaiService.getAll());
        return "/chi_tiet_khuyen_mai/index";
    }

    @GetMapping("/chi-tiet-khuyen-mai/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("ctkm") ChiTietKhuyenMai chiTietKhuyenMai, Model model) {
        model.addAttribute("view", "../chi_tiet_khuyen_mai/index.jsp");
        model.addAttribute("chiTietSP", chiTietSanPhamService.getAll());
        model.addAttribute("khuyenMai", khuyenMaiService.getAll());
        model.addAttribute("ctkm", new ChiTietKhuyenMai());
        return "/chi_tiet_khuyen_mai/add";
    }

    @PostMapping("/chi-tiet-khuyen-mai/hien-thi-add")
    public String add(@Valid @ModelAttribute("ctkm") ChiTietKhuyenMai chiTietKhuyenMai, Model model, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/chi_tiet_khuyen_mai/add.jsp");
            return "/chi_tiet_khuyen_mai/add";
        }
        chiTietKhuyenMaiService.add(chiTietKhuyenMai);
        return "redirect:/admin/chi-tiet-khuyen-mai/hien-thi";
    }

    @GetMapping("/chi-tiet-khuyen-mai/view-update/{id}")
    public String hienThiUPDATE(@PathVariable Long id, Model model) {
        ChiTietKhuyenMai chiTietKhuyenMai = chiTietKhuyenMaiService.getChiTietKhuyenMaiById(id);
        List<ChiTietSanPham> chiTietSPList = chiTietSanPhamService.getAll();
        List<KhuyenMai> khuyenMaiList = khuyenMaiService.getAll();

        model.addAttribute("chiTietSP", chiTietSPList);
        model.addAttribute("khuyenMai", khuyenMaiList);
        model.addAttribute("chiTietKhuyenMai", chiTietKhuyenMai);
        model.addAttribute("ctkm", new ChiTietKhuyenMai());


        return "/chi_tiet_khuyen_mai/view_update";
    }

    @PostMapping("/chi-tiet-khuyen-mai/view-update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("chiTietKhuyenMai") ChiTietKhuyenMai chiTietKhuyenMai, Model model) {
        model.addAttribute("ctkm", new ChiTietKhuyenMai());
        chiTietKhuyenMai.setId(id);
        chiTietKhuyenMaiService.add(chiTietKhuyenMai);
        return "redirect:/admin/chi-tiet-khuyen-mai/hien-thi";
    }

    @GetMapping("/chi-tiet-khuyen-mai/remove/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        chiTietKhuyenMaiService.remove(id);
        return "redirect:/admin/chi-tiet-khuyen-mai/hien-thi";
    }


}
