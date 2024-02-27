package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    @Query("SELECT nv FROM NhanVien nv where nv.ten LIKE %?1% or nv.ma like %?1%")
    Page<NhanVien> search(String key, Pageable pageable);

    @Query("select nv from NhanVien nv where  nv.ma =?1")
    NhanVien getSanPhamByMaSP(String maCl);
}
