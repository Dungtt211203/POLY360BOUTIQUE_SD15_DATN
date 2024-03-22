package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, Long> {

    @Query(value = "select * from gio_Hang_Chi_Tiet where gio_hang_id = :idGioHang ", nativeQuery = true)
    List<GioHangChiTiet> getGioHangChiTietByIdGioHang(@Param("idGioHang") Long idGioHang);


    @Query(value = " SELECT * FROM Gio_Hang_Chi_Tiet where gio_hang_id = :idGioHang AND chi_tiet_san_pham_id = :idSPCT ", nativeQuery = true)
    GioHangChiTiet getGioHangChiTietByGioHangAndAndSanPhamChiTiet(@Param("idGioHang") Long idGioHang, @Param("idSPCT") Long idSPCT);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gio_hang_chi_tiet WHERE gio_hang_id = :idGioHang", nativeQuery = true)
    void deleteAllByIdGioHang(@Param("idGioHang") Long idGioHang);



}
