package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SanPhamService {


    Page<SanPham> getData(int page);

    SanPham getOne(String id);

    List<SanPham> getAll();

    void add(SanPham sanPham);

    void remove(UUID id);
}
