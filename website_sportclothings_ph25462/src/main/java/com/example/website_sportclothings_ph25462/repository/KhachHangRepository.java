package com.example.website_sportclothings_ph25462.repository;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    @Query("SELECT kh FROM KhachHang kh where kh.ten LIKE %?1% or kh.ma like %?1%")
    Page<KhachHang> search(String key, Pageable pageable);

    @Query("select kh from KhachHang kh where  kh.ma =?1")
    KhachHang getSanPhamByMaKH(String maKH);
}
