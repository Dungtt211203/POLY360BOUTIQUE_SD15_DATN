package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.repository.MauSacRepository;
import com.example.website_sportclothings_ph25462.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepository msr;
    @Override
    public List<MauSac> getAll() {
        return msr.findAll();
    }
    @Override
    public void add(MauSac mauSac) {
        msr.save(mauSac);
    }

    @Override
    public void remove(UUID id) {
        msr.deleteById(id);
    }
}
