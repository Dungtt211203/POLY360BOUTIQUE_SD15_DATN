package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import com.example.website_sportclothings_ph25462.repository.ThuongHieuRepository;
import com.example.website_sportclothings_ph25462.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<ThuongHieu> getAll(Pageable pageable) {
        return thr.findAll(pageable);
    }

    @Override
    public void remove(Long id) {
        thr.deleteById(id);
    }

    @Override
    public ThuongHieu update(Long id) {
        return thr.findById(id).orElse(null);
    }

    @Override
    public Page<ThuongHieu> search(String key, Pageable pageable) {
        return thr.search(key, pageable);
    }

    public ThuongHieu getOne(String maCL) {
        return thr.getSanPhamByMaSP(maCL);
    }
}
