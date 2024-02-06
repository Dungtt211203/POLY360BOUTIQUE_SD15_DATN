package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import com.example.website_sportclothings_ph25462.repository.ThuongHieuRepository;
import com.example.website_sportclothings_ph25462.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    ThuongHieuRepository thr;
    @Override
    public List<ThuongHieu> getAll() {
        return thr.findAll();
    }

    @Override
    public void add(ThuongHieu thuongHieu) {
    thr.save(thuongHieu);
    }

    @Override
    public void remove(UUID id) {
    thr.deleteById(id);
    }
}
