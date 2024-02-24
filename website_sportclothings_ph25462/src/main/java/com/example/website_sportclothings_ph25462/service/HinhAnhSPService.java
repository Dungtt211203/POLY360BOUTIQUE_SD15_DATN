package com.example.website_sportclothings_ph25462.service;


import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import org.springframework.data.domain.Page;

import java.util.List;


public interface HinhAnhSPService {

    Page<HinhAnhSP> getData(Integer page);

    HinhAnhSP getOne(String id);

    List<HinhAnhSP> getAll();


}