package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface ThuongHieuService {
    List<ThuongHieu> getAll();

    void  add(ThuongHieu thuongHieu);

    void remove(UUID id);
}
