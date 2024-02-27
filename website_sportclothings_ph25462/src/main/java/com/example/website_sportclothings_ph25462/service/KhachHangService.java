package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KhachHangService {
    List<KhachHang> getAll();

    KhachHang add(KhachHang khachHang);

    void remove(Long id);

    KhachHang update(Long id);

    Page<KhachHang> search(String key, Pageable pageable);

    KhachHang getOne(String maKH);
}
