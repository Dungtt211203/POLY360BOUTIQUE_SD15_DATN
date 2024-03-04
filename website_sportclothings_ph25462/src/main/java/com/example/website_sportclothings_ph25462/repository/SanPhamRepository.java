package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {


    @Query("SELECT sp FROM SanPham sp where sp.ten LIKE %?1% or sp.ma like %?1%")
    Page<SanPham> search(String key, Pageable pageable);

    @Query("select sp from SanPham sp where  sp.ma =?1")
    SanPham getSanPhamByMaSP(String maSP);
}
