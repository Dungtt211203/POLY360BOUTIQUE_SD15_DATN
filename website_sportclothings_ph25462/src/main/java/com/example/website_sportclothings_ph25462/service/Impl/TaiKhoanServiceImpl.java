package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.TaiKhoanRepository;
import com.example.website_sportclothings_ph25462.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;


    @Override
    public void add(TaiKhoan taiKhoan) {
        taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public TaiKhoan checkLogin(String tenTK, String matKhau) {
        return taiKhoanRepository.findTaiKhoanByTenTKAndMatKhau(tenTK, matKhau);
    }
}
