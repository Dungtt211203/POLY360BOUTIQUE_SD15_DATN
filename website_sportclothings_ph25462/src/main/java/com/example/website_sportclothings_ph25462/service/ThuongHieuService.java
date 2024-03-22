package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThuongHieuService {

    List<ThuongHieu> getAll();

    void add(ThuongHieu thuongHieu);

    void remove(Long id);

    ThuongHieu update(Long id);

    Page<ThuongHieu> search(String key, Pageable pageable);

    ThuongHieu getOne(String maTH);

    Page<ThuongHieu> getAll(Pageable pageable);
}
