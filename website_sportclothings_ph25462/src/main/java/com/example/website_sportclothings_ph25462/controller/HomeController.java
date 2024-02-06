package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import com.example.website_sportclothings_ph25462.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/poly360boutique")

public class HomeController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private ThuongHieuService thuongHieuService;


    @GetMapping("/home")

    public String index(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {

        Page<SanPham> sanPham = sanPhamService.getData(page);
        model.addAttribute("product", sanPham);

        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        model.addAttribute("thuonghieu", thuongHieuList);

        return "/template_home/index";
    }

}
