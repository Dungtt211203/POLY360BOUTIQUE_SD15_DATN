package com.example.website_sportclothings_ph25462.service;


import com.example.website_sportclothings_ph25462.entity.MauSac;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MauSacService {
    List<MauSac> getAll();

    void add(MauSac mauSac);

    void remove(Long id);

    MauSac update(Long id);

    MauSac getOne(String maMS);
}
