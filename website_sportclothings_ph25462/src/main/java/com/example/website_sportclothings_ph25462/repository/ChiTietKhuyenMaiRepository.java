package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ChiTietKhuyenMaiRepository extends JpaRepository<ChiTietKhuyenMai, Long> {
    @Query("select ctkm from ChiTietKhuyenMai ctkm where  ctkm.maChiTietKhuyenMai =?1")
    ChiTietKhuyenMai getChiTietKhuyenMaiBy(String maCTKM);

    Page<ChiTietKhuyenMai> findAll(Pageable pageable);
}
