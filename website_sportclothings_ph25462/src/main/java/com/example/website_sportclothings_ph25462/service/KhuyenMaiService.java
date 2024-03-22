package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KhuyenMaiService {
    List<KhuyenMai> getAll();

    KhuyenMai add(KhuyenMai khuyenMai);

    void remove(Long id);

    KhuyenMai update(Long id);
}