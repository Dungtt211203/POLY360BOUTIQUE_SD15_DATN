package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KichCoService {
    List<KichCo> getAll();

    void add(KichCo kichCo);

    void remove(Long id);


    KichCo update(Long id);

    KichCo getOne(String maKC);

    Page<KichCo> getAll(Pageable pageable);
}
