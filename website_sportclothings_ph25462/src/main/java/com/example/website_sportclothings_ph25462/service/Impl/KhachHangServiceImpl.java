package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.repository.KhachHangRepository;
import com.example.website_sportclothings_ph25462.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository khr;

    @Override
    public List<KhachHang> getAll() {
        return khr.findAll();
    }

    @Override
    public KhachHang add(KhachHang khachHang) {
        return khr.save(khachHang);
    }

    @Override
    public KhachHang update(Long id) {
        return khr.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        khr.deleteById(id);
    }

    @Override
    public Page<KhachHang> search(String key, Pageable pageable) {
        return khr.search(key, pageable);
    }

    public KhachHang getOne(String maKH) {
        return khr.getSanPhamByMaKH(maKH);
    }
}
