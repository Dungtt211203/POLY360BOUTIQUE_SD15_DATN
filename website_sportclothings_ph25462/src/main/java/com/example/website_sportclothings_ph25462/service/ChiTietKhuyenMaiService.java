package com.example.website_sportclothings_ph25462.service;


import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ChiTietKhuyenMaiService {
    List<ChiTietKhuyenMai> getAll();

    ChiTietKhuyenMai add(ChiTietKhuyenMai chiTietKhuyenMai);

    ChiTietKhuyenMai update(Long id);

    void remove(Long id);
}
