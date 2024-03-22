package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface HinhAnhSPRepository extends JpaRepository<HinhAnhSP, Long> {
    @Query(value = "SELECT * FROM hinh_anh_san_pham where san_pham_id = :idSanPham", nativeQuery = true)
    List<HinhAnhSP> getHinhAnhSPByIdSP(@Param("idSanPham") Long idSanPham);
}
