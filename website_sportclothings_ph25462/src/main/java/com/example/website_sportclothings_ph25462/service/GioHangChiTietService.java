package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GioHangChiTietService {

    public List<GioHangChiTiet> getAllByKhachHang(KhachHang khachHang);

    public List<GioHangChiTiet> getAll();

    public GioHangChiTiet add(GioHangChiTiet gioHangChiTiet);

    public GioHangChiTiet update(GioHangChiTiet gioHangChiTiet);

    public void delete(Long id);

    public GioHangChiTiet getGioHangChiTietByIdGioHangAndIdCTSP(long idGioHang, long idSPCT);

    public GioHangChiTiet getOne(Long id);

    public void loginAddToCart();

    public void clearAll(long idGioHang);

}
