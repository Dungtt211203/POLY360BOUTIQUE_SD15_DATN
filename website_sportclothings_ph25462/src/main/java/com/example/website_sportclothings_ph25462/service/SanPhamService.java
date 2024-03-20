package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface SanPhamService {


    Page<SanPham> getData(Integer page);

    List<SanPham> getAll();

    void add(SanPham sanPham);

    void remove(Long id);

    SanPham Detail(String id);

    SanPham update(Long id);

    SanPham getOne(String maCL);

    SanPham getById(long id);

    Page<SanPham> search(String key, Pageable pageable);


}
