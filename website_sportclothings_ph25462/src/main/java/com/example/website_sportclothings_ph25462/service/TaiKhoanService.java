package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import org.springframework.stereotype.Service;


@Service
public interface TaiKhoanService {

    void add(TaiKhoan taiKhoan);

    TaiKhoan checkLogin(String tenTK, String matKhau);


}
