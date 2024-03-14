package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import com.example.website_sportclothings_ph25462.service.KhuyenMaiService;
import com.example.website_sportclothings_ph25462.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CapNhatTrangThaiController {
    @Autowired
    KhuyenMaiService khuyenMaiService;

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    VoucherService voucherService;

    @Scheduled(cron = "0 49 16 * * ?") // 0h everyday
    public void run() {
        System.out.println("Lịch trình chạy...");
        LocalDateTime now = LocalDateTime.now();
        for (KhuyenMai khuyenMai : khuyenMaiService.getAll()) {
            if (khuyenMai.getTrangThai() == 1 && khuyenMai.getNgayTao().isBefore(now)) {
                khuyenMai.setTrangThai(2L); //sắp diễn ra -> đang hoạt động//
                khuyenMaiService.add(khuyenMai);
                List<ChiTietKhuyenMai> chiTietKhuyenMaiList = khuyenMai.getChiTietKhuyenMaiList();
                if (chiTietKhuyenMaiList != null) {
                    for (ChiTietKhuyenMai chiTietKhuyenMai : chiTietKhuyenMaiList) {
                        ChiTietSanPham chiTietSP = chiTietKhuyenMai.getChiTietSP();
                        if (chiTietKhuyenMai.getHinhThucGiam() == 1) {
                            chiTietSP.setGiaHienHanh((long) (chiTietSP.getGiaGoc() * (100 - chiTietKhuyenMai.getGiaTriGiam()) / 100));
                        }
//                        else if (chiTietKhuyenMai.getHinhThucGiam() == 0) {
//                            chiTietSP.setGiaHienHanh(chiTietSP.getGiaGoc() - chiTietKhuyenMai.getGiaTriGiam());
//                        }
                        chiTietSanPhamService.save(chiTietSP);
                    }
                }
            } else if (khuyenMai.getTrangThai() == 2 && khuyenMai.getNgayKetThuc().isBefore(now)) {
                khuyenMai.setTrangThai(4L); //dang hoat dong -> het han//
                khuyenMaiService.add(khuyenMai);
                List<ChiTietKhuyenMai> chiTietKhuyenMaiList = khuyenMai.getChiTietKhuyenMaiList();
                if (chiTietKhuyenMaiList != null) {
                    for (ChiTietKhuyenMai chiTietKhuyenMai : chiTietKhuyenMaiList) {
                        ChiTietSanPham chiTietSP = chiTietKhuyenMai.getChiTietSP();
                        chiTietSP.setGiaHienHanh(chiTietSP.getGiaGoc());
                        chiTietSanPhamService.save(chiTietSP);
                    }
                }
            } else if (khuyenMai.getTrangThai() == 3 && khuyenMai.getNgayKetThuc().isBefore(now)) {
                khuyenMai.setTrangThai(4L); //ngung hoat dong//
                khuyenMaiService.add(khuyenMai);
                List<ChiTietKhuyenMai> chiTietKhuyenMaiList = khuyenMai.getChiTietKhuyenMaiList();
                if (chiTietKhuyenMaiList != null) {
                    for (ChiTietKhuyenMai chiTietKhuyenMai : chiTietKhuyenMaiList) {
                        ChiTietSanPham chiTietSP = chiTietKhuyenMai.getChiTietSP();
                        chiTietSP.setGiaHienHanh(chiTietSP.getGiaGoc());
                        chiTietSanPhamService.save(chiTietSP);
                    }
                }
                khuyenMaiService.add(khuyenMai);
            }
        }
    }
}
