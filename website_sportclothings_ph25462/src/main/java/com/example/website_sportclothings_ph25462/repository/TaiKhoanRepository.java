package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {

    TaiKhoan getTaiKhoanByEmail(String email);

    TaiKhoan findTaiKhoanByEmail(String email);


}
