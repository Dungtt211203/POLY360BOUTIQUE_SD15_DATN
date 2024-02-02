package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MauSacService {
    Page<MauSac> search(String key, Pageable pageable);
    List<MauSac> getAll();
}
