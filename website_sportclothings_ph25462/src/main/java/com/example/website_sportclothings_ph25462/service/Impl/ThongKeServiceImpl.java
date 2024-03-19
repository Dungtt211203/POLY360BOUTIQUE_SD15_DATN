package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.repository.ThongKeRepository;
import com.example.website_sportclothings_ph25462.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ThongKeServiceImpl implements ThongKeService {
    @Autowired
    ThongKeRepository thongKeRepository;

    @Override
    public Long getTongDoanhThuNgayThangNam(int day, int month, int year) {
        return thongKeRepository.tongDoanhThuNgayThangNam(day, month, year);
    }

    @Override
    public Long getTongSoLuongBanNgayThangNam(LocalDateTime startDate, LocalDateTime endDate) {
        return thongKeRepository.tongSoLuongBanDuocTheoNgayThangNam(startDate, endDate);
    }

    @Override
    public Long getTongSoLuongHoaDonTheoNgayThangNam(int day, int month, int year,int trangThai) {
        return thongKeRepository.tongSoLuongHoaDonTheoNgayThangNam(day, month, year,trangThai);
    }

    @Override
    public Map<String, Long> getThongKeDoanhThuTheoThang() {
        List<Object[]> objects = thongKeRepository.thongKeDoanhThuTheoThang();

        Map<String, Long> thongKe = new LinkedHashMap<>();

        for (Object[] row : objects) {
            String thang = (String) row[0];
            Long doanhThu = (Long) row[1];
            thongKe.put(thang, doanhThu);
        }
        return thongKe;
    }


}
