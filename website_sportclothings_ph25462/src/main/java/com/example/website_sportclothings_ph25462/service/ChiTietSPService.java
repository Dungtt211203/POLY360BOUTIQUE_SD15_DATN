package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import com.example.website_sportclothings_ph25462.entity.KichCo;

import java.util.List;


public interface ChiTietSPService {

    List<ChiTietSP> getAll();

    void remove(Long id);
}
