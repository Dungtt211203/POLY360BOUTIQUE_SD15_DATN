package com.example.website_sportclothings_ph25462.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ThongKeRepository extends JpaRepository<HoaDon, Long> {

    @Query("SELECT COALESCE(SUM(hd.tongTien), 0) FROM HoaDon hd WHERE DAY(hd.ngayTao) = :day AND MONTH(hd.ngayTao) = :month AND YEAR(hd.ngayTao) = :year ")
    Long tongDoanhThuNgayThangNam(@Param("day") int day, @Param("month") int month, @Param("year") int year);



    @Query("SELECT COALESCE(SUM(hdct.soLuong), 0) FROM HoaDonChiTiet hdct " +
            "JOIN hdct.hoaDon hd " +
            "WHERE hd.ngayTao BETWEEN :startDate AND :endDate " +
            "AND hd.trangThai = 1 ")
    Long tongSoLuongBanDuocTheoNgayThangNam(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    //so luong hoa don
    @Query("SELECT COUNT(hd) FROM HoaDon hd " +
            "WHERE DAY(hd.ngayTao) = :day AND MONTH(hd.ngayTao) = :month AND YEAR(hd.ngayTao) = :year " +
            "AND hd.trangThai = :trangThai")
    Long tongSoLuongHoaDonTheoNgayThangNam(@Param("day") int day, @Param("month") int month, @Param("year") int year,@Param("trangThai") int trangThai);



//    @Query("SELECT COUNT(hd) FROM HoaDon hd " +
//            "WHERE hd.ngayTao BETWEEN :startDate AND :endDate " +
//            "AND hd.trangThai = 1")
//    Long tongSoLuongHoaDonTheoNgayThangNam(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    // thong ke theo thang
    @Query("SELECT CONCAT(MONTH (hd.ngayTao), '/', YEAR (hd.ngayTao)),SUM(hd.tongTien)" +
            "FROM HoaDon hd WHERE hd.trangThai = 1 GROUP BY MONTH(hd.ngayTao) , YEAR (hd.ngayTao)")
    List<Object[]> thongKeDoanhThuTheoThang();
}
