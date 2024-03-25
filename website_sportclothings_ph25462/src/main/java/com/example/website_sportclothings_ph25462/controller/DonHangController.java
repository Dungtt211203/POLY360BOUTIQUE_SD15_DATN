package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.HoaDon;
import com.example.website_sportclothings_ph25462.entity.HoaDonChiTiet;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.HoaDonChiTietService;
import com.example.website_sportclothings_ph25462.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/donHang")
public class DonHangController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;

//    @GetMapping("/products")
//    public String search(@RequestParam(defaultValue = "") String keyword,
//                         @RequestParam(defaultValue = "name") String sortBy,
//                         @RequestParam(defaultValue = "ASC") String direction,
//                         Pageable pageable, Model model) {
//        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
//        Page<HoaDon> products = hoaDonService.search(keyword, sort, pageable);
//        model.addAttribute("products", products);
//        model.addAttribute("keyword", keyword);
//        model.addAttribute("sortBy", sortBy);
//        model.addAttribute("direction", direction);
//        return "product-list";
//    }


    @GetMapping("/getAll")
    public String hienThi(Model model) {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        if (taiKhoan == null) {
            return "redirect:/login";
        }

        List<HoaDon> hoaDonList = hoaDonService.getAllByKhachHang();
        model.addAttribute("donHangList", hoaDonList);
        return "/don_hang/don-hang";
    }


    @GetMapping("/donHangChiTiet/{idDonHang}")
    public String orderDetail(Model model, @PathVariable long idDonHang) {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        try {
            if (taiKhoan == null) {
                return "redirect:/login";
            }
            if (taiKhoan != null) {
                List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietService.getHDCTByIdHoaDon(idDonHang);
                model.addAttribute("donHangChiTietList", hoaDonChiTietList);
                model.addAttribute("maDonHang", hoaDonChiTietList.get(0).getHoaDon().getMaHoaDon());
                model.addAttribute("tongTien", hoaDonChiTietList.get(0).getHoaDon().getTongTien());
                return "/don_hang/don-hang-chi-tiet";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/don_hang/don-hang-chi-tiet";
    }

    @ModelAttribute("principal")
    public TaiKhoan principal() {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        return taiKhoan;
    }

    @GetMapping("/huy/{idHDCT}")
    public String khachHangHuyDonHang(@PathVariable long idHDCT) {
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietService.getOne(idHDCT);
        HoaDon hoaDon = hoaDonService.getOne(hoaDonChiTiet.getHoaDon().getId());
        hoaDon.setTongTien(hoaDon.getTongTien() - (hoaDonChiTiet.getDonGia() * hoaDonChiTiet.getSoLuong()));
        hoaDonChiTiet.setTrangThai(0);

        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietService.getHDCTByIdHoaDon(hoaDon.getId());
        int count = 0;
        for (HoaDonChiTiet hDCT : hoaDonChiTietList) {
            if (hDCT.getTrangThai() == 1) {
                count += 1;
                System.out.printf("///////: " + count + "   ");
            }
        }
        if (count == 0) {
            hoaDon.setTongTien(0L);
            hoaDon.setTrangThai(0);
        }

        hoaDonService.update(hoaDon);
        hoaDonChiTietService.update(hoaDonChiTiet);


        return "redirect:/donHang/donHangChiTiet/" + hoaDonChiTiet.getHoaDon().getId();
    }


}
