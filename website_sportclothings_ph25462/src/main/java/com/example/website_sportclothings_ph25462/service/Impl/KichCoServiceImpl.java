package com.example.website_sportclothings_ph25462.service.Impl;

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
    public void add(KichCo mauSac) {
        kcr.save(mauSac);
    }

    @Override
    public void remove(UUID id) {
        kcr.deleteById(id);
    }
}
