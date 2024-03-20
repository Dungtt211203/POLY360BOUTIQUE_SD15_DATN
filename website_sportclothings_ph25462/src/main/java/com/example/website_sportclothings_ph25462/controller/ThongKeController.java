package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.service.HoaDonService;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import com.example.website_sportclothings_ph25462.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ThongKeController {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    ThongKeService thongKeService;

    @GetMapping("/thong-ke/hien-thi")
    public String hienThiThongKe(@RequestParam(name = "year", required = false, defaultValue = "2024") int year,
                                 @RequestParam(name = "month", required = false, defaultValue = "02") int month,
                                 @RequestParam(name = "day", required = false, defaultValue = "01") int day,
                                 @RequestParam(name = "trangThai", required = false, defaultValue = "01") int trangThai,

                                 @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
                                 @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate,

                                 Model model) {
        //doanh thu ngay thang nam
        Long doanhThuNgayThangNam = thongKeService.getTongDoanhThuNgayThangNam(day, month, year);

        //so luong san pham
        Long tongSoLuong = thongKeService.getTongSoLuongBanNgayThangNam(startDate, endDate);

        //so luong hoa don
        Long tongSoLuongHoaDon = thongKeService.getTongSoLuongHoaDonTheoNgayThangNam(day,month,year,trangThai);

        //thong ke theo bieu do
        Map<String, Long> thongKeDoanhThuTheoThang = thongKeService.getThongKeDoanhThuTheoThang();


        model.addAttribute("thongKeDoanhThuTheoThang", thongKeDoanhThuTheoThang);

        model.addAttribute("doanhThuNgayThangNam", doanhThuNgayThangNam);
        model.addAttribute("tongSoLuong", tongSoLuong);
        model.addAttribute("tongSoLuongHoaDon", tongSoLuongHoaDon);

        model.addAttribute("day", day);
        model.addAttribute("month", month);
        model.addAttribute("year", year);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("view", "../thong_ke/index.jsp");

        return "/thong_ke/index";
    }

}
