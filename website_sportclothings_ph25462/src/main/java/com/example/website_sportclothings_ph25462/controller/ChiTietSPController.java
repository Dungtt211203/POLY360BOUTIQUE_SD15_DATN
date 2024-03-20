package com.example.website_sportclothings_ph25462.controller;


import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/chitietsp")
public class ChiTietSPController {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private KichCoRepository kichCoRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private ChatLieuRepository chatLieuRepository;
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;


    @GetMapping("/hien-thi")
    public String view(Model model) {
        model.addAttribute("list", chiTietSanPhamRepository.findAll());
        model.addAttribute("sp", new ChiTietSanPham());
        model.addAttribute("view", "../chitietsp/index.jsp");
        model.addAttribute("sanPham", sanPhamRepository.findAll());
        model.addAttribute("kichCo", kichCoRepository.findAll());
        model.addAttribute("mauSac", mauSacRepository.findAll());
        model.addAttribute("chatLieu", chatLieuRepository.findAll());
        model.addAttribute("thuongHieu", thuongHieuRepository.findAll());
        return "/chitietsp/index";
    }

    @GetMapping("/viewadd")
    public String hienThiAdd(@ModelAttribute("ctsp") ChiTietSanPham chiTietSP, Model model) {
        //   model.addAttribute("view", "../chitietsp/index.jsp");
        model.addAttribute("sanPham", sanPhamRepository.findAll());
        model.addAttribute("kichCo", kichCoRepository.findAll());
        model.addAttribute("mauSac", mauSacRepository.findAll());
        model.addAttribute("chatLieu", chatLieuRepository.findAll());
        model.addAttribute("thuongHieu", thuongHieuRepository.findAll());
        model.addAttribute("ctsp", new ChiTietSanPham());
        return "chitietsp/add";
    }

    @PostMapping("/add")
    public String add(ChiTietSanPham chiTietSp, Model model) {
        model.addAttribute("sp", new ChiTietSanPham());

        ChiTietSanPham chiTietSanPhamDB = chiTietSanPhamRepository.getAllByIdSanPhamAndIdMauSacAndIdKichCo(chiTietSp.getSanPham().getId(), chiTietSp.getKichCo().getId(), chiTietSp.getMauSac().getId());

        if (chiTietSanPhamDB != null) {

            chiTietSanPhamDB.setSoLuong(chiTietSanPhamDB.getSoLuong() + chiTietSp.getSoLuong());
            chiTietSanPhamRepository.save(chiTietSanPhamDB);
            return "redirect:/admin/chitietsp/hien-thi";
        } else



        chiTietSanPhamRepository.save(chiTietSp);
        return "redirect:/admin/chitietsp/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        chiTietSanPhamRepository.deleteById(id);
        return "redirect:/chitietsp/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable Long id, Model model) {
        ChiTietSanPham chiTietSp = chiTietSanPhamRepository.findById(id).orElse(null);
        //   model.addAttribute("view", "../chitietsp/index.jsp");
        model.addAttribute("sanPham", sanPhamRepository.findAll());
        model.addAttribute("kichCo", kichCoRepository.findAll());
        model.addAttribute("mauSac", mauSacRepository.findAll());
        model.addAttribute("chatLieu", chatLieuRepository.findAll());
        model.addAttribute("thuongHieu", thuongHieuRepository.findAll());
        model.addAttribute("sp", new ChiTietSanPham());
        model.addAttribute("chitietsp", chiTietSp);
        return "chitietsp/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("chitietsp") ChiTietSanPham chiTietSp, Model model) {
        model.addAttribute("sp", new ChiTietSanPham());

        ChiTietSanPham chiTietSanPhamDB = chiTietSanPhamRepository.getAllByIdSanPhamAndIdMauSacAndIdKichCo(chiTietSp.getSanPham().getId(), chiTietSp.getKichCo().getId(), chiTietSp.getMauSac().getId());
        System.out.println("Không cộng số lượng vào sản phẩm" + chiTietSanPhamDB.getId());
        if (chiTietSanPhamDB != null) {

            chiTietSanPhamDB.setSoLuong(chiTietSanPhamDB.getSoLuong() + chiTietSp.getSoLuong());
            chiTietSanPhamRepository.save(chiTietSanPhamDB);
            return "redirect:/admin/chitietsp/hien-thi";
        } else {

        }


        chiTietSp.setId(id);
        chiTietSanPhamRepository.save(chiTietSp);
        return "redirect:/admin/chitietsp/hien-thi";
    }


}


