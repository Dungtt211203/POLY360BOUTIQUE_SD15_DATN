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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
