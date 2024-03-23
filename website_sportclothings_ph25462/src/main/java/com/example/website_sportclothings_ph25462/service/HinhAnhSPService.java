package com.example.website_sportclothings_ph25462.service;


import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface HinhAnhSPService {

    Page<HinhAnhSP> getData(Integer page);

    HinhAnhSP getOne(String id);

    List<HinhAnhSP> getAll();

    List<HinhAnhSP> getHinhAnhSPByIdSP(Long idSanPham);

    void add(HinhAnhSP hinhAnhSP);

    void remove(Long id);

    HinhAnhSP update(Long id);

    Page<HinhAnhSP> getAll(Pageable pageable);

}
