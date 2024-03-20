package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.*;
import com.example.website_sportclothings_ph25462.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/poly360boutique")

public class HomeController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private HinhAnhSPService hinhAnhSPService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private KichCoService kichCoService;

    @Autowired
    private ThuongHieuService thuongHieuService;


    @GetMapping("/home")

    public String index(@RequestParam(defaultValue = "0", name = "page") Integer page,
                        Model model, @Param("search") String key, Pageable pageable) {

        Page<SanPham> sanPhams = sanPhamService.getData(page);

        if (key != null) {
            sanPhams = this.sanPhamService.search(key, pageable);
        }

        model.addAttribute("hienthi", sanPhams);


        List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getAll();
        model.addAttribute("ctsp", chiTietSanPhamList);

        List<HinhAnhSP> hinhAnhSPList = hinhAnhSPService.getAll();
        model.addAttribute("hinhanhsp", hinhAnhSPList);


        return "/template_home/index";
    }


    @GetMapping("/san-pham/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        SanPham sanPham = sanPhamService.getOne(id);

        Page<SanPham> sanPhams = sanPhamService.getData(0);
        model.addAttribute("hienthi", sanPhams);

        List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getAll();
        model.addAttribute("ctsp", chiTietSanPhamList);

        List<HinhAnhSP> hinhAnhSPList = hinhAnhSPService.getAll();
        model.addAttribute("hinhanhsp", hinhAnhSPList);


        model.addAttribute("detail", sanPham);
        return "/template_home/detail";
    }


    @GetMapping("/dang-nhap")
    public String dangNhap(Model model) {

        model.addAttribute("taikhoan", new TaiKhoan());
        return ("/login/dangnhap");
    }

    @GetMapping("/logout")
    public String doGetLogout(HttpSession session) {
        session.removeAttribute("taikhoan");
        session.removeAttribute("cart");
        return "redirect:/poly360boutique/dang-nhap";
    }

    @PostMapping("/login")
    public String login(

            @RequestParam("username") String username,
            @RequestParam("password") String password,

            Model model, @ModelAttribute(name = "taikhoan") TaiKhoan taiKhoan,
            HttpSession session) {

        TaiKhoan taiKhoans = taiKhoanService.checkLogin(username, password);

        if (taiKhoans != null && taiKhoans.getVaiTro() == null) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return "redirect:/poly360boutique/home";

        } else if (taiKhoans != null && taiKhoans.getVaiTro() == 1) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return ("/admin/index");

        } else if (taiKhoans != null && taiKhoans.getVaiTro() == 3) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return ("/admin/index");

        } else if (taiKhoans != null && taiKhoans.getVaiTro() == 2) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return "redirect:/poly360boutique/home";

        } else {
            session.setAttribute("taikhoanlogin", null);
        }

        model.addAttribute("message", "Ten tai khoan hoac mat khau khong dung");

        return ("/login/dangnhap");
    }


    @GetMapping("/thuong-hieu/nike")
    public String thuongHieuNike(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<SanPham> sanPhams = sanPhamService.getData(page);
        model.addAttribute("hienthi", sanPhams);


        List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getAll();
        model.addAttribute("ctsp", chiTietSanPhamList);

        List<HinhAnhSP> hinhAnhSPList = hinhAnhSPService.getAll();
        model.addAttribute("hinhanhsp", hinhAnhSPList);

        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        model.addAttribute("thuonghieu", thuongHieuList);

        return "/template_home/nike";
    }

    @GetMapping("/thuong-hieu/adidas")
    public String thuongHieuAdidas(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<SanPham> sanPhams = sanPhamService.getData(page);
        model.addAttribute("hienthi", sanPhams);


        List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getAll();
        model.addAttribute("ctsp", chiTietSanPhamList);

        List<HinhAnhSP> hinhAnhSPList = hinhAnhSPService.getAll();
        model.addAttribute("hinhanhsp", hinhAnhSPList);

        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        model.addAttribute("thuonghieu", thuongHieuList);

        return "/template_home/adidas";
    }

    @GetMapping("/thuong-hieu/puma")
    public String thuongHieuPuma(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<SanPham> sanPhams = sanPhamService.getData(page);
        model.addAttribute("hienthi", sanPhams);


        List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getAll();
        model.addAttribute("ctsp", chiTietSanPhamList);

        List<HinhAnhSP> hinhAnhSPList = hinhAnhSPService.getAll();
        model.addAttribute("hinhanhsp", hinhAnhSPList);

        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        model.addAttribute("thuonghieu", thuongHieuList);

        return "/template_home/puma";
    }

    @GetMapping("/thuong-hieu/li-ning")
    public String thuongHieuLining(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<SanPham> sanPhams = sanPhamService.getData(page);
        model.addAttribute("hienthi", sanPhams);


        List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getAll();
        model.addAttribute("ctsp", chiTietSanPhamList);

        List<HinhAnhSP> hinhAnhSPList = hinhAnhSPService.getAll();
        model.addAttribute("hinhanhsp", hinhAnhSPList);

        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        model.addAttribute("thuonghieu", thuongHieuList);

        return "/template_home/li-ning";
    }

    @GetMapping("/product")
    public String productAll(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<SanPham> sanPhams = sanPhamService.getData(page);
        model.addAttribute("hienthi", sanPhams);


        List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getAll();
        model.addAttribute("ctsp", chiTietSanPhamList);

        List<HinhAnhSP> hinhAnhSPList = hinhAnhSPService.getAll();
        model.addAttribute("hinhanhsp", hinhAnhSPList);

        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        model.addAttribute("thuonghieu", thuongHieuList);

        return "/template_home/product";
    }

}
