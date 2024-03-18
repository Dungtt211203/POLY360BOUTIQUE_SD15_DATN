package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface SanPhamService {

    List<SanPham> getAll();

    void add(SanPham sanPham);

    void remove(Long id);

    SanPham Detail(String id);

    SanPham update(Long id);

    SanPham getOne(String maCL);

    SanPham getById(long id);

    Page<SanPham> getAll(Pageable pageable);

}
