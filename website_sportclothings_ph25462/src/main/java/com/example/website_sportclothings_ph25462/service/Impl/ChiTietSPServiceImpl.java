package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import com.example.website_sportclothings_ph25462.repository.ChatLieuRepository;
import com.example.website_sportclothings_ph25462.repository.ChiTietSPRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    ChiTietSPRepository chiTietSP;
    @Override
    public List<ChiTietSP> getAll() {
        return chiTietSP.findAll();
    }

    @Override
    public void remove(Long id) {
        chiTietSP.deleteById(id);
    }
}
