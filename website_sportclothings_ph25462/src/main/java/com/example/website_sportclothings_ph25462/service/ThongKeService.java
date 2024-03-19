package com.example.website_sportclothings_ph25462.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public interface ThongKeService {

    Long getTongDoanhThuNgayThangNam(int day, int month, int year);

    Long getTongSoLuongBanNgayThangNam(LocalDateTime startDate, LocalDateTime endDate);

    Long getTongSoLuongHoaDonTheoNgayThangNam(int day, int month, int year,int trangThai);


    Map<String ,Long> getThongKeDoanhThuTheoThang();
}
