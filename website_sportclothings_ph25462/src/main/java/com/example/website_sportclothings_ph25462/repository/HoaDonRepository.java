package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    @Query(value = " SELECT TOP 1 id FROM hoa_don ORDER BY id DESC ", nativeQuery = true)
    Long gietIdMax();

    @Query(value = " SELECT * FROM hoa_don WHERE tai_khoan_id = :idTaiKhoan ORDER BY ngay_tao DESC ", nativeQuery = true)
    List<HoaDon> getAllHDByKhachHang(@Param("idTaiKhoan") long idTaiKhoan);

    @Query(value = " SELECT * FROM hoa_don WHERE trang_thai = 1 ORDER BY id DESC ", nativeQuery = true)
    List<HoaDon> getDonHangThanhCong();

    @Query(value = " SELECT * FROM hoa_don WHERE trang_thai = 2 ORDER BY id DESC ", nativeQuery = true)
    List<HoaDon> getDonHangChoXacNhan();

    @Query(value = " SELECT * FROM hoa_don WHERE trang_thai = 3 ORDER BY id DESC ", nativeQuery = true)
    List<HoaDon> getDonHangChoGiao();

    @Query(value = " SELECT * FROM hoa_don WHERE trang_thai = 4 ORDER BY id DESC ", nativeQuery = true)
    List<HoaDon> getDonHangDangGiao();
}
