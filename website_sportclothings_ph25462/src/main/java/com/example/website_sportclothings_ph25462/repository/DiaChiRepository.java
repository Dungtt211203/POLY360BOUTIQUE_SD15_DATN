package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiaChiRepository extends JpaRepository<DiaChi, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE DiaChi a SET a.trangThai = 0 WHERE a.taiKhoanKH.id = :khachHangId AND a.id != :currentAddressId")
    void updateAllAddressesToNonPrimary(@Param("khachHangId") Long khachHangId, @Param("currentAddressId") Long currentAddressId);

    @Query(value = "SELECT MAX(id) AS max_id FROM dia_chi ", nativeQuery = true)
    Long idMax();

    @Query(value = "SELECT * FROM dia_chi where tai_khoan_id = :idKH ORDER BY id DESC ;", nativeQuery = true)
    List<DiaChi> getAllByKH(@Param("idKH") long idKH);
}

