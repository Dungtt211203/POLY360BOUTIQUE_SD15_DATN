package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl {
    @Autowired
    MauSacRepository msr;
    public List<MauSac> getAll() {
        return msr.findAll();
    }
}
