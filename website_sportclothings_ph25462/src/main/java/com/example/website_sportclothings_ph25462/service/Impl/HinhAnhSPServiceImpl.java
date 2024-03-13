package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import com.example.website_sportclothings_ph25462.repository.HinhAnhSPRepository;
import com.example.website_sportclothings_ph25462.service.HinhAnhSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HinhAnhSPServiceImpl implements HinhAnhSPService {

    @Autowired
    HinhAnhSPRepository hinhAnhSPRepository;


    @Override
    public List<HinhAnhSP> getAll() {
        return hinhAnhSPRepository.findAll();
    }

    @Override
    public HinhAnhSP getOne(String id) {

        return hinhAnhSPRepository.findById(Long.valueOf(id)).orElse(null);
    }


}
