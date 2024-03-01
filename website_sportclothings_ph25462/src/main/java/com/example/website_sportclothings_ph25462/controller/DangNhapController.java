//package com.example.website_sportclothings_ph25462.controller;
//
//import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
//import com.example.website_sportclothings_ph25462.entity.SanPham;
//import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
//import com.example.website_sportclothings_ph25462.service.HinhAnhSPService;
//import com.example.website_sportclothings_ph25462.service.SanPhamService;
//import com.example.website_sportclothings_ph25462.service.TaiKhoanService;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/poly360boutique")
//
//public class DangNhapController {
//
//    @Autowired
//    private TaiKhoanService taiKhoanService;
//
//    @Autowired
//    private SanPhamService sanPhamService;
//
//    @Autowired
//    private HinhAnhSPService hinhAnhSPService;
//
//
//    @GetMapping("/home")
//
//    public String index(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {
//
//        Page<HinhAnhSP> hinhAnhSPS = hinhAnhSPService.getData(page);
//        model.addAttribute("hienthi", hinhAnhSPS);
//
//
//        List<SanPham> sanPhamList = sanPhamService.getAll();
//        model.addAttribute("sanpham", sanPhamList);
//
//        return "/template_home/index";
//    }
//
//    @GetMapping("/dang-nhap")
//    public String dangNhap() {
//
//        return ("/login/dangnhap");
//    }
//
//    @GetMapping("/logout")
//    public String doGetLogout(HttpSession session) {
//        session.removeAttribute("user");
//        session.removeAttribute("cart");
//        return "/template_home/cart";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("username") String tenTK,
//                        @RequestParam("password") String matKhau,
//                        HttpSession session) {
//        TaiKhoan taiKhoan = taiKhoanService.checkLogin(tenTK, matKhau);
//        if (taiKhoan != null) {
//            session.setAttribute("taikhoan", taiKhoan);
//            return "redirect:/poly360boutique/home";
//        }
//        return "redirect:/dang-nhap";
//    }
//
//}
