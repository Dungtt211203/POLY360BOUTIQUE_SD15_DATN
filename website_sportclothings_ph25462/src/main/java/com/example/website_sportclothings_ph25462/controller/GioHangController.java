package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GioHangController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private ChiTietSPService chiTietSanPhamService;

    @Autowired
    HttpSession session;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;


    @PostMapping({"/add-to-cart/{idSanPham}"})
    public String addToCart(@PathVariable long idSanPham, @RequestParam("mauSac") long idMauSac, @RequestParam("size") long idKichCo,
                            @RequestParam("soLuong") Integer soLuong) {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        if (taiKhoan != null) {

            KhachHang khachHang = khachHangService.getKHByIdTaiKhoan(taiKhoan.getId());

            long idGioHang = gioHangService.kiemTraGioHangCuaKhachHang(khachHang).getId();
            long idSPCT = chiTietSanPhamService.getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(idSanPham, idMauSac, idKichCo).getId();
            GioHangChiTiet gioHangChiTiet = gioHangChiTietService.getGioHangChiTietByIdGioHangAndIdCTSP(idGioHang, idSPCT);
            if (gioHangChiTiet == null) {

                gioHangChiTiet = new GioHangChiTiet();
                gioHangChiTiet.setSoLuong(soLuong);
                ChiTietSP chiTietSanPham = chiTietSanPhamService.getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(idSanPham, idMauSac, idKichCo);
                gioHangChiTiet.setChiTietSanPham(chiTietSanPham); //
                gioHangChiTiet.setGioHang(gioHangService.kiemTraGioHangCuaKhachHang(khachHang));
                gioHangChiTietService.add(gioHangChiTiet);
                return "redirect:/poly360boutique/san-pham/detail/" + idSanPham;

            }
            gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + soLuong); // số lượng cũ cộng số lượng mới
            gioHangChiTietService.add(gioHangChiTiet);
            return "redirect:/poly360boutique/san-pham/detail/" + idSanPham;
        }


        if (taiKhoan == null) { // khách hàng không đămg nhập lưu vào session.
            ChiTietSP chiTietSanPham = chiTietSanPhamService.getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(idSanPham, idMauSac, idKichCo);
            List<GioHangChiTiet> gioHangChiTietSession = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");


            if (gioHangChiTietSession == null) {
                gioHangChiTietSession = new ArrayList<>();
                session.setAttribute("gioHangCT", gioHangChiTietSession);
            }
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setId(0L);
            gioHangChiTiet.setSoLuong(soLuong); //3
            gioHangChiTiet.setChiTietSanPham(chiTietSanPham);

            if (gioHangChiTietSession.size() > 0) {
                for (int i = 0; i < gioHangChiTietSession.size(); i++) {
                    if (gioHangChiTietSession.get(i).getChiTietSanPham().getId() == chiTietSanPham.getId()) {
                        GioHangChiTiet gioHangCT = gioHangChiTietSession.get(i);
                        gioHangCT.setSoLuong(gioHangCT.getSoLuong() + gioHangChiTiet.getSoLuong());
                        gioHangChiTietSession.set(i, gioHangCT);
                        return "redirect:/poly360boutique/san-pham/detail/" + idSanPham;
                    }
                }
            }
            gioHangChiTietSession.add(gioHangChiTiet);
        }

        return "redirect:/poly360boutique/san-pham/detail/" + idSanPham;

    }


    @GetMapping("/gio-hang")
    public String chinhSuaGioHang(Model model) {
        List<GioHangChiTiet> items = cartItems();
        Float tongTien = 0F;
        model.addAttribute("carts", items);

        if (items != null) {
            for (GioHangChiTiet gioHangChiTiet : items) {
                tongTien += gioHangChiTiet.getSoLuong() * gioHangChiTiet.getChiTietSanPham().getGiaHienHanh();
            }
            model.addAttribute("tongTien", tongTien);
        }


        return "/gio_hang/gio-hang-index";
    }

    @ModelAttribute(name = "carts")
    public List<GioHangChiTiet> cartItems() {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();


        if (taiKhoan != null) {
            KhachHang khachHang = khachHangService.getKHByIdTaiKhoan(taiKhoan.getId());
            System.out.printf("KH " + khachHang.getTen());
            List<GioHangChiTiet> gioHangChiTietDB = gioHangChiTietService.getAllByKhachHang(khachHang);

            return gioHangChiTietDB;
        }
        List<GioHangChiTiet> gioHangChiTietList = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
        if (taiKhoan == null) {

            if (gioHangChiTietList != null) {
                System.out.printf("số luộng SP gio hang vvvv: " + gioHangChiTietList.size());
            }
            return gioHangChiTietList;
        }

        return gioHangChiTietList;
    }


    @GetMapping("/shopping-cart/remove/{idOrIndex}")
    public String xoaSPTrongGioHang(@PathVariable("idOrIndex") int idOrIndex, Model model) {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();

        if (taiKhoan != null) {
            gioHangChiTietService.delete(Long.valueOf(idOrIndex));
            return "redirect:/gio-hang";
        }
        if (taiKhoan == null) {
            List<GioHangChiTiet> items = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
            items.remove(idOrIndex);
            model.addAttribute("carts", items);
            return "redirect:/gio-hang";
        }

        return "redirect:/gio-hang";
    }


    @GetMapping("/shopping-cart/up/{idOrIndex}")
    public String congMotSanPham(@PathVariable("idOrIndex") int idOrIndex, Model model) {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        if (taiKhoan != null) {
            GioHangChiTiet gioHangChiTiet = gioHangChiTietService.getOne(Long.valueOf(idOrIndex));

            if (gioHangChiTiet != null) {
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
                gioHangChiTietService.update(gioHangChiTiet);
                return "redirect:/gio-hang";
            }
        }

        if (taiKhoan == null) {
            List<GioHangChiTiet> items = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
            GioHangChiTiet cartItem = items.get(idOrIndex);
            cartItem.setSoLuong(cartItem.getSoLuong() + 1);
            items.set(idOrIndex, cartItem);
            model.addAttribute("carts", items);
            return "redirect:/gio-hang";
        }
        return "redirect:/gio-hang";

    }


    @GetMapping("/shopping-cart/down/{idOrIndex}")  // lấy id hoặc index
    public String truMotSanPham(@PathVariable("idOrIndex") int idOrIndex, Model model) {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();

        if (taiKhoan != null) {
            GioHangChiTiet gioHangChiTiet = gioHangChiTietService.getOne(Long.valueOf(idOrIndex));

            if (gioHangChiTiet != null) {
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() - 1);

                if (gioHangChiTiet.getSoLuong() == 0) {
                    gioHangChiTietService.delete(gioHangChiTiet.getId());
                }
                if (gioHangChiTiet.getSoLuong() != 0) {
                    gioHangChiTietService.update(gioHangChiTiet);
                }

                return "redirect:/gio-hang";
            }
        }

        if (taiKhoan == null) {
            // get theo index khi chưa đăng nhập
            List<GioHangChiTiet> items = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
            GioHangChiTiet cartItem = items.get(idOrIndex);
            cartItem.setSoLuong(cartItem.getSoLuong() - 1);

            if (cartItem.getSoLuong() == 0) {
                items.remove(idOrIndex);
                model.addAttribute("carts", items);
                return "redirect:/gio-hang";
            }
            items.set(idOrIndex, cartItem);
            model.addAttribute("carts", items);
            return "redirect:/gio-hang";
        }
        return null;
    }


}
