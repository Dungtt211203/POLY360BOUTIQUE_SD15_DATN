package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.repository.HinhAnhSPRepository;
import com.example.website_sportclothings_ph25462.service.HinhAnhSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HinhAnhSPServiceImpl implements HinhAnhSPService {

    @Autowired
    HinhAnhSPRepository hinhAnhSPRepository;


    @Override
    public Page<HinhAnhSP> getData(Integer page) {

        Pageable pageable = PageRequest.of(page, 4);

        return hinhAnhSPRepository.findAll(pageable);
    }

    @Override
    public HinhAnhSP getOne(String id) {
        return hinhAnhSPRepository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public List<HinhAnhSP> getAll() {
        return hinhAnhSPRepository.findAll();
    }

    @Override
    public List<HinhAnhSP> getHinhAnhSPByIdSP(Long idSanPham) {
        return hinhAnhSPRepository.getHinhAnhSPByIdSP(idSanPham);
    }

    @Override
    public Page<HinhAnhSP> getAll(Pageable pageable) {
        return hinhAnhSPRepository.findAll(pageable);
    }
    @Override
    public void add(HinhAnhSP hinhAnhSP) {
        hinhAnhSPRepository.save(hinhAnhSP);
    }

    @Override

    public HinhAnhSP update(Long id) {
        return hinhAnhSPRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        hinhAnhSPRepository.deleteById(id);
    }
}
