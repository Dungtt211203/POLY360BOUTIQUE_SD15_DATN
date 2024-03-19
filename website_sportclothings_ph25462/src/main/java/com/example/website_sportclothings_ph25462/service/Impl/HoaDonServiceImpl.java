package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.HoaDon;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.HoaDonRepository;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {


    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;


    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public List<HoaDon> getAllByKhachHang() {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        return hoaDonRepository.getAllHDByKhachHang(taiKhoan.getId());
    }


    @Override
    public HoaDon add(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon update(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon getOne(Long id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        hoaDonRepository.delete(getOne(id));
    }

    @Override
    public List<HoaDon> getAllDonHangThanhCong() {
        return hoaDonRepository.getDonHangThanhCong();
    }

    @Override
    public List<HoaDon> getDonHangChoXacNhan() {
        return hoaDonRepository.getDonHangChoXacNhan();
    }

    @Override
    public List<HoaDon> getDonHangChoGiao() {
        return hoaDonRepository.getDonHangChoGiao();
    }

    @Override
    public List<HoaDon> getDonHangDangGiao() {
        return hoaDonRepository.getDonHangDangGiao();
    }

    @Override
    public HoaDon getDonHangById(Long id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

}
