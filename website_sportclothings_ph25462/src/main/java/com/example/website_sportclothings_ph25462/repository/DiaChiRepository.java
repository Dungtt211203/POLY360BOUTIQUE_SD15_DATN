package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.DiaChi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface DiaChiRepository extends JpaRepository<DiaChi, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE DiaChi a SET a.trangThai = 0 WHERE a.taiKhoanKH.id = :khachHangId AND a.id != :currentAddressId")
    void updateAllAddressesToNonPrimary(@Param("khachHangId") Long khachHangId, @Param("currentAddressId") Long currentAddressId);
}
