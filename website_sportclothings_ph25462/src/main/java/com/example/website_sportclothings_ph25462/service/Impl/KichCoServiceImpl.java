package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.repository.KichCoRepository;
import com.example.website_sportclothings_ph25462.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KichCoServiceImpl implements KichCoService {
    @Autowired
    KichCoRepository kcr;

    @Override
    public List<KichCo> getAll() {
        return kcr.findAll();
    }

    @Override
    public void add(KichCo kichCo) {
        kcr.save(kichCo);
    }

    @Override

    public KichCo update(Long id) {
        return kcr.findById(id).orElse(null);

    }

    @Override

    public void remove(Long id) {
        kcr.deleteById(id);
    }
    public KichCo getOne(String maKC) {
        return kcr.getSanPhamByMaKC(maKC);
    }
}
