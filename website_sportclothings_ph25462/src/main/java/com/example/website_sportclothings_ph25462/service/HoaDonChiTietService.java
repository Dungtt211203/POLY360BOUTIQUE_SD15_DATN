package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.HoaDonChiTiet;
import com.example.website_sportclothings_ph25462.entity.KhachHang;

import java.util.List;

public interface HoaDonChiTietService {

    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);

    public HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet);

    public HoaDonChiTiet getOne(Long id);

    public List<HoaDonChiTiet> getAll();

    public void delete(Long id);

    public List<HoaDonChiTiet> getHDCTByIdHoaDon(long id);

    public HoaDon createOrder(KhachHang kh, String address, List<GioHangChiTiet> gioHangChiTietList, Long phiVanChuyen);

}
