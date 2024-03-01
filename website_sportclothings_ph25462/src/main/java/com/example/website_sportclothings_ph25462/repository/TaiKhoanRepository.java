package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {

    TaiKhoan findTaiKhoanByTenTKAndMatKhau(String tenTK, String matKhau);

}
