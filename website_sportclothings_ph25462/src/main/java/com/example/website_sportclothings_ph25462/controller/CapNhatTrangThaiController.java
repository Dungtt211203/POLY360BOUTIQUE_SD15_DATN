package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import com.example.website_sportclothings_ph25462.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CapNhatTrangThaiController {
    @Autowired
    KhuyenMaiService khuyenMaiService;

    @Autowired
    ChiTietSanPhamService chiTietSPService;

    public void run() {
        LocalDateTime now = LocalDateTime.now();

        for (KhuyenMai khuyenMai : khuyenMaiService.getAll()) {
            if (khuyenMai.getTrangThai() == 1 && khuyenMai.getNgayTao().isBefore(now)) {
                khuyenMai.setTrangThai(2L); //sắp diễn ra -> đang hoạt động//
                khuyenMaiService.add(khuyenMai);
            }
        }
    }
}


