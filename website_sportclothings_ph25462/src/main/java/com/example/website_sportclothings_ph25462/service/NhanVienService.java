package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NhanVienService {
    List<NhanVien> getAll();

    NhanVien add(NhanVien nhanVien);

    void remove(Long id);

    NhanVien update(Long id);

    Page<NhanVien> search(String key, Pageable pageable);

    NhanVien getOne(String maNV);
}
