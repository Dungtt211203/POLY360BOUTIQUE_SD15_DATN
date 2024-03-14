package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.entity.MauSac;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface KichCoService {
    List<KichCo> getAll();

    void add(KichCo kichCo);

    void remove(UUID id);

    KichCo update(UUID id);
}
