package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SanPhamService {
    List<SanPham> getAll();

    void add(SanPham sanPham);

    void remove(UUID id);
}
