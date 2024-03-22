package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.repository.SanPhamRepository;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public SanPham update(Long id) {
        return spr.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        spr.deleteById(id);
    }

    @Override
    public SanPham Detail(String id) {
        return spr.findById(Long.valueOf(id)).orElse(null);
    }

    public SanPham getOne(String maCL) {

        return spr.getSanPhamByMaSP(maCL);
    }
    public Page<SanPham> getData(Integer page) {

        Pageable pageable = PageRequest.of(page, 4);

        return spr.findAll(pageable);
    }
    @Override
    public SanPham getById(long id) {
        return spr.findById(id).orElse(null);
    }


    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return spr.findAll(pageable);
    }


}
