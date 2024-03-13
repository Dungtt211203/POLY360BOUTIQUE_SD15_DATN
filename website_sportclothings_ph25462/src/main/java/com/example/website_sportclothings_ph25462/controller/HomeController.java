package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.*;
import com.example.website_sportclothings_ph25462.service.*;
//import com.example.website_sportclothings_ph25462.service.ThuongHieuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/home")

    public String index(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<ChiTietSanPham> chiTietSanPhams = chiTietSanPhamService.getData(page);
        model.addAttribute("hienthi", chiTietSanPhams);


        List<SanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("sanpham", sanPhamList);
        return "/template_home/index";
    }

    @GetMapping("/chi-tiet-san-pham")
    public String view(Model model) {

        List<ChiTietSanPham> chiTietSPS = chiTietSPService.getAll();
        model.addAttribute("chitietsanpham", chiTietSPS);
        List<HinhAnhSP> hinhAnhSPList = hinhAnhSPService.getAll();
        model.addAttribute("hinhanh", hinhAnhSPList);

        List<KichCo> kichCos = kichCoService.getAll();
        model.addAttribute("kichco", kichCos);

        List<MauSac> mauSacs = mauSacService.getAll();
        model.addAttribute("mausac", mauSacs);


        return "/template_home/index";
    }


//    @GetMapping("/san-pham/detail/{id}")
//    public String detail(@PathVariable("id") String id, Model model) {
//
//        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(id);
//
//        Page<ChiTietSanPham> chi = hinhAnhSPService.getData(0);
//        model.addAttribute("hienthi", hinhAnhSPS);
//
//
//        model.addAttribute("detail", hinhAnhSP);
//        return "/template_home/detail";
//    }


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

        if (taiKhoans != null && taiKhoans.getVaiTro() == 1) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return "redirect:/poly360boutique/home";
        } else if (taiKhoans != null && taiKhoans.getVaiTro() == 3) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return "redirect:/poly360boutique/admin";
        } else if (taiKhoans != null && taiKhoans.getVaiTro() == 2) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return "redirect:/poly360boutique/admin";
        } else {
            session.setAttribute("taikhoanlogin", null);
        }

        model.addAttribute("message", "Ten tai khoan hoac mat khau khong dung");

        return ("/login/dangnhap");
    }


}
