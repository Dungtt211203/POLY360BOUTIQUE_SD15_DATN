package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Long> {
    @Query("SELECT th FROM ChatLieu th where th.ten LIKE %?1% or th.ma like %?1%")
    Page<ThuongHieu> search(String key, Pageable pageable);

    @Query("select th from ThuongHieu th where  th.ma =?1")
    ThuongHieu getSanPhamByMaSP(String maTH);

    Page<ThuongHieu> findAll(Pageable pageable);
}
