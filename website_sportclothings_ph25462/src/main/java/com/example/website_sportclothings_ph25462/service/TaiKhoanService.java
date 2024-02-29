package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.dto.TaiKhoandto;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TaiKhoanService {

    List<TaiKhoan> getAll();

    void add(TaiKhoandto taiKhoandto);

    Boolean checkPassword(String email, String matkhau);

    Boolean checkTaikhoanbyEmail(String email);

    TaiKhoan getTaiKhoanbyEmail(String email);

}
