package com.example.website_sportclothings_ph25462.service;


import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;


public interface HinhAnhSPService {

    List<HinhAnhSP> getAll();

    HinhAnhSP getOne(String id);


}