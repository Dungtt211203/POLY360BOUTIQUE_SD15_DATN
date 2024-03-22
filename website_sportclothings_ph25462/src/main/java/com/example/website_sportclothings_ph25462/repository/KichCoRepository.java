package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KichCoRepository extends JpaRepository<KichCo, Long> {
    @Query("select kc from KichCo kc where  kc.ma =?1")
    KichCo getSanPhamByMaKC(String maKC);

    Page<KichCo> findAll(Pageable pageable);
}
