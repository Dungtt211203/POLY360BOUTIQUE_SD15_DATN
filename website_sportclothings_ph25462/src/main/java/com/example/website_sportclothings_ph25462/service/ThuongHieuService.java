package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThuongHieuService {
    List<ThuongHieu> getAll();

    void add(ThuongHieu thuongHieu);

    void remove(Long id);

}
