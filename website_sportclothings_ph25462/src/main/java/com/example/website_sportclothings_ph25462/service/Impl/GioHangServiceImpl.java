package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.repository.GioHangRepository;
import com.example.website_sportclothings_ph25462.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    private GioHangRepository gioHangRepository;

    @Override
    public GioHang kiemTraGioHangCuaKhachHang(KhachHang khachHang) {

        if (gioHangRepository.getAllByKhachHang(khachHang) == null) {
            GioHang gioHang = new GioHang();

//            Date ngayHienTai = new Date();
//            gioHang.setNgayTao(ngayHienTai);

            gioHang.setKhachHang(khachHang);
            gioHang.setTt(true);
//            gioHang.setNgayTao( );
            gioHangRepository.save(gioHang);
            return gioHang;
        }
        return gioHangRepository.getGioHangByKhachHang(khachHang);
    }

}
