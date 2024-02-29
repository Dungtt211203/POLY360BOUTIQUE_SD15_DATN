package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.dto.TaiKhoandto;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.TaiKhoanRepository;
import com.example.website_sportclothings_ph25462.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<TaiKhoan> getAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public void add(TaiKhoandto taiKhoandto) {

        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String creationDate = Date.format(formatter);
        TaiKhoan taiKhoan = new TaiKhoan(
                null,
                ".",
                ".",
                null,
                null,
                0,
                taiKhoandto.getEmail(),
                taiKhoandto.getTenTK(),
                taiKhoandto.getMatKhau(),
                null,
                null
        );

        taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public Boolean checkPassword(String email, String matkhau) {
        TaiKhoan taiKhoan = taiKhoanRepository.findTaiKhoanByEmail(email);
        if (taiKhoan.getMatKhau().equals(matkhau)) return true;
        return false;
    }

    @Override
    public Boolean checkTaikhoanbyEmail(String email) {
        TaiKhoan taiKhoan = taiKhoanRepository.findTaiKhoanByEmail(email);
        if (taiKhoan == null) return false;
        return true;
    }

    @Override
    public TaiKhoan getTaiKhoanbyEmail(String email) {
        return taiKhoanRepository.getTaiKhoanByEmail(email);
    }

}
