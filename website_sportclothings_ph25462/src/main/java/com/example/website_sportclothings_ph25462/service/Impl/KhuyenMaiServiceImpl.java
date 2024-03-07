package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.repository.KhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> getAll() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public KhuyenMai add(KhuyenMai khuyenMai) {
        return khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void remove(Long id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public KhuyenMai update(Long id) {
        return khuyenMaiRepository.findById(id).orElse(null);
    }

}