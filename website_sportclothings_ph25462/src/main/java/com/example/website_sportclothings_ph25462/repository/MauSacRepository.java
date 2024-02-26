package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Long> {
    @Query("select ms from MauSac ms where  ms.ma =?1")
    MauSac getSanPhamByMaMS(String maMS);
}
