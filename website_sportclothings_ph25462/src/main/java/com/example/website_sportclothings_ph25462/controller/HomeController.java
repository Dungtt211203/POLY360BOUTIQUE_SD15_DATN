package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import com.example.website_sportclothings_ph25462.service.HinhAnhSPService;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
//import com.example.website_sportclothings_ph25462.service.ThuongHieuService;
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

//    @Autowired
//    private ThuongHieuService thuongHieuService;

    @Autowired
    private HinhAnhSPService hinhAnhSPService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;


    @GetMapping("/home")

    public String index(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<HinhAnhSP> hinhAnhSPS = hinhAnhSPService.getData(page);
        model.addAttribute("hienthi", hinhAnhSPS);

//        Page<ChiTietSanPham> chiTietSanPhams = chiTietSanPhamService.getData(page);
//        model.addAttribute("hienthi", chiTietSanPhams);

        List<SanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("sanpham", sanPhamList);

        return "/template_home/index";
    }

}