package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.repository.SanPhamRepository;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository spr;
    @Override
    public List<SanPham> getAll() {
        return spr.findAll();
    }
    @Override
    public void add(SanPham sanPham) {
        spr.save(sanPham);
    }

    @Override
    public void remove(UUID id) {
        spr.deleteById(id);
    }
}
