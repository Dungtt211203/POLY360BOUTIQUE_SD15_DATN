package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.SanPham;

import java.util.List;


public interface SanPhamService {

    List<SanPham> getAll();

    void add(SanPham sanPham);

    void remove(Long id);

    SanPham update(Long id);

    SanPham getOne(String maCL);

}
