package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
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
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    HttpSession session;

    @PostMapping({"/add-to-cart/{idSanPham}"})
    public String addToCart(@PathVariable long idSanPham, @RequestParam("mauSac") long idMauSac, @RequestParam("size") long idKichCo, @RequestParam("soLuong") Integer soLuong, Model model) {


        SanPham product = sanPhamService.getById(idSanPham);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(idSanPham, idMauSac, idKichCo);
        List<GioHangChiTiet> gioHangChiTietSession = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");

        if (gioHangChiTietSession == null) {
            gioHangChiTietSession = new ArrayList<>();
            session.setAttribute("gioHangCT", gioHangChiTietSession);
        }
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setSoLuong(soLuong);
        gioHangChiTiet.setChiTietSanPham(chiTietSanPham);

        gioHangChiTietSession.add(gioHangChiTiet);
        for (GioHangChiTiet gioHangChiTiet1: gioHangChiTietSession
        ) {
            System.out.printf("okokzzzzz" + gioHangChiTiet1.getChiTietSanPham().getKichCo().getTen());
        }





        return "redirect:/poly360boutique/thuong-hieu-nike";
    }

//    @GetMapping("/gio-hang")
//    public String chinhSuaGioHang(Model model){
//        List<GioHangChiTiet> items = cartItems(model);
//        Float tongTien = 0F;
//        model.addAttribute("carts", items);
//
//        for (GioHangChiTiet gioHangChiTiet: items) {
//            tongTien +=  gioHangChiTiet.getSoLuong() * gioHangChiTiet.getChiTietSanPham().getGia();
//        }
//        model.addAttribute("tongTien", tongTien);
//
//        return "/gio_hang/gio-hang-index";
//    }

    @ModelAttribute(name = "carts")
    public List<GioHangChiTiet> cartItems(Model model) {
        List<GioHangChiTiet> items = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
        if(items == null){
            items = new ArrayList<>();
        }

        return items;
    } // thiếu giở hàng khi đăng nhập của khách hàng


    @GetMapping("/shopping-cart/remove/{idOrIndex}")
    public String xoaSPTrongGioHang(@PathVariable("idOrIndex") int idOrIndex, Model model) {

        List<GioHangChiTiet> items = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
        items.remove(idOrIndex);
        model.addAttribute("carts", items);
        return "redirect:/gio-hang";

    }


    @GetMapping("/shopping-cart/up/{idOrIndex}")
    public String congMotSanPham(@PathVariable("idOrIndex") int idOrIndex, Model model) {

        List<GioHangChiTiet> items = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
        GioHangChiTiet cartItem = items.get(idOrIndex);
        cartItem.setSoLuong(cartItem.getSoLuong() + 1);
        items.set(idOrIndex, cartItem);
        model.addAttribute("carts", items);
        return "redirect:/gio-hang";

    }


    @GetMapping("/shopping-cart/down/{idOrIndex}")  // lấy id hoặc index
    public String truMotSanPham(@PathVariable("idOrIndex") int idOrIndex, Model model) {


        // get theo index khi chưa đăng nhập
        List<GioHangChiTiet> items = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
        GioHangChiTiet cartItem = items.get(idOrIndex);
        cartItem.setSoLuong(cartItem.getSoLuong() - 1);
        if(cartItem.getSoLuong() == 0){
            items.remove(idOrIndex);
            model.addAttribute("carts", items);
            return "redirect:/gio-hang";
        }
        items.set(idOrIndex, cartItem);
        model.addAttribute("carts", items);
        return "redirect:/gio-hang";

    }
}
