package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.GioHang;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {


    GioHang getAllByKhachHang(KhachHang khachHang);

    GioHang getGioHangByKhachHang(KhachHang khachHang);


}
