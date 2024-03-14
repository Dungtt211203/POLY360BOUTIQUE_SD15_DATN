package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.KichCo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KichCoRepository extends JpaRepository<KichCo, Long> {
    @Query("select kc from KichCo kc where  kc.ma =?1")
    KichCo getSanPhamByMaKC(String maKC);
}
