package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.HoaDon;

import java.util.List;

public interface HoaDonService {

    public List<HoaDon> getAll();

    public List<HoaDon> getAllByKhachHang();

    public HoaDon add(HoaDon hoaDon);

    public HoaDon update(HoaDon hoaDon);

    public HoaDon getOne(Long id);

    public void delete(Long id);

    public List<HoaDon> getAllDonHangThanhCong();

    public List<HoaDon> getDonHangChoXacNhan();

    public List<HoaDon> getDonHangChoGiao();

    public List<HoaDon> getDonHangDangGiao();

    public HoaDon getDonHangById(Long id);



}
