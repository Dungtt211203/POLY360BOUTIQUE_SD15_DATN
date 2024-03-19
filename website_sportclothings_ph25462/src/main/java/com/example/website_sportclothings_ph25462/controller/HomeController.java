package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.*;
import com.example.website_sportclothings_ph25462.repository.KhachHangRepository;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private KhachHangRepository khachHangRepository;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;

    @Autowired
    private HttpSession session;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private KichCoService kichCoService;


    @GetMapping("/home")

    public String index(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<HinhAnhSP> hinhAnhSPS = hinhAnhSPService.getData(page);
        model.addAttribute("hienthi", hinhAnhSPS);


        List<SanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("sanpham", sanPhamList);

        return "/template_home/index";
    }


    @GetMapping("/san-pham/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {


        try {
            HinhAnhSP hinhAnhSP = hinhAnhSPService.getOne(id);
            Page<HinhAnhSP> hinhAnhSPS = hinhAnhSPService.getData(0);
            model.addAttribute("hienthi", hinhAnhSPS);

            SanPham sanPham = sanPhamService.getById(Long.valueOf(id));
            List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getCTSPByIdSanPham(sanPham.getId());
            Set<MauSac> mauSacSet = (Set) chiTietSanPhamList.stream().map(ChiTietSanPham::getMauSac).collect(Collectors.toSet());
            Set<KichCo> kichCoSet = (Set) chiTietSanPhamList.stream().map(ChiTietSanPham::getKichCo).collect(Collectors.toSet());
            model.addAttribute("sanPham", sanPham);
            model.addAttribute("listMauSac", mauSacSet);
            model.addAttribute("listKichCo", kichCoSet);

            model.addAttribute("detail", hinhAnhSP);
            return "/template_home/detail";
        } catch (Exception e) {
            e.printStackTrace();
        }
    @GetMapping("/chi-tiet-san-pham")
    public String view(Model model) {

        List<ChiTietSanPham> chiTietSPS = chiTietSanPhamService.getAll();
        model.addAttribute("chitietsanpham", chiTietSPS);

        List<KichCo> kichCos = kichCoService.getAll();
        model.addAttribute("kichco", kichCos);

        List<MauSac> mauSacs = mauSacService.getAll();
        model.addAttribute("mausac", mauSacs);


        return "/chitietsp/index";
    }


    @GetMapping("/san-pham/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        HinhAnhSP hinhAnhSP = hinhAnhSPService.getOne(id);
        Page<HinhAnhSP> hinhAnhSPS = hinhAnhSPService.getData(0);
        model.addAttribute("hienthi", hinhAnhSPS);
        model.addAttribute("detail", hinhAnhSP);
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

    @ModelAttribute("principal")
    public TaiKhoan principal() {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        return taiKhoan;
    }

    @ModelAttribute(name = "carts")
    public List<GioHangChiTiet> cartItems() {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();

        if (taiKhoan != null) {
            KhachHang khachHang = khachHangRepository.getKhachHangByIdTaiKhoan(taiKhoan.getId());
            System.out.printf("KH " + khachHang.getTen());
            List<GioHangChiTiet> gioHangChiTietDB = gioHangChiTietService.getAllByKhachHang(khachHang);

            return gioHangChiTietDB;
        }

        if (taiKhoan == null) {
            List<GioHangChiTiet> gioHangChiTietList = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
            if (gioHangChiTietList != null) {
                System.out.printf("số luộng SP gio hang vvvv: " + gioHangChiTietList.size());
            }
            return gioHangChiTietList;
        }

        return null;
    }

}
    @PostMapping("/login")
    public String login(

            @RequestParam("username") String username,
            @RequestParam("password") String password,

            Model model, @ModelAttribute(name = "taikhoan") TaiKhoan taiKhoan,
            HttpSession session) {

        TaiKhoan taiKhoans = taiKhoanService.checkLogin(username, password);

        if (taiKhoans != null && taiKhoans.getVaiTro() == 2) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return "redirect:/poly360boutique/home";

        } else if (taiKhoans != null && taiKhoans.getVaiTro() == 1) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return ("/admin/index");

        } else if (taiKhoans != null && taiKhoans.getVaiTro() == 3) {
            session.setAttribute("taikhoanlogin", taiKhoans);
            return ("/admin/index");

        } else {
            session.setAttribute("taikhoanlogin", null);
        }

        model.addAttribute("message", "Ten tai khoan hoac mat khau khong dung");

        return ("/login/dangnhap");
    }


}
