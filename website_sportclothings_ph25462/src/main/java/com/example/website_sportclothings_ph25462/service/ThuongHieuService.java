package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ThuongHieu;

import java.util.List;

public interface ThuongHieuService {

    List<ThuongHieu> getAll();

    ThuongHieu getOne(String id);
}
