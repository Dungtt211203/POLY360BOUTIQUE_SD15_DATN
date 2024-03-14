package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.NhanVien;
import com.example.website_sportclothings_ph25462.repository.NhanVienRepository;
import com.example.website_sportclothings_ph25462.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRepository nvr;

    @Override
    public List<NhanVien> getAll() {
        return nvr.findAll();
    }

    @Override
    public NhanVien add(NhanVien nhanVien) {
        return nvr.save(nhanVien);
    }

    @Override
    public NhanVien update(Long id) {
        return nvr.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        nvr.deleteById(id);
    }

    @Override
    public Page<NhanVien> search(String key, Pageable pageable) {
        return nvr.search(key, pageable);
    }

    public NhanVien getOne(String maCL) {
        return nvr.getSanPhamByMaSP(maCL);
    }
}
