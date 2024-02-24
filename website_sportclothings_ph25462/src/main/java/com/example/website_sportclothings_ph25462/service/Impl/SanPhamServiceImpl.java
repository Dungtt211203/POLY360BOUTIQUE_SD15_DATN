package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.repository.SanPhamRepository;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
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
<<<<<<< HEAD
    public SanPham update(Long id) {
        return spr.findById(id).orElse(null);
    }

    @Override
=======
>>>>>>> hoanglc_PH27504
    public void remove(Long id) {
        spr.deleteById(id);
    }
}
