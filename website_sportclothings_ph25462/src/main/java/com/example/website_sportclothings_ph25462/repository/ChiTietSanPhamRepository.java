package com.example.website_sportclothings_ph25462.repository;


import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, Long> {

    @Query(value = "SELECT * FROM ChiTietSP ", nativeQuery = true)
    List<ChiTietSanPham> getAll();

    @Query(
            value = "SELECT * FROM chi_Tiet_san_pham where san_pham_id = :id ",
            nativeQuery = true
    )
    List<ChiTietSanPham> getAllByIdSanPham(@Param("id") long id);


    @Query(value = " SELECT * FROM chi_Tiet_san_pham where san_pham_id = :idSP and mau_sac_id = :idMauSac and kich_co_id = :idKichCo ", nativeQuery = true)
    ChiTietSanPham getAllByIdSanPhamAndIdMauSacAndIdKichCo(@Param("idSP") long idSP, @Param("idMauSac") long idMauSac, @Param("idKichCo") long idKichCo);

    @Query(value = "SELECT so_luong FROM Chi_tiet_san_pham WHERE san_pham_id = :idSanPham AND mau_sac_id = :idMauSac AND kich_co_id = :idKichCo", nativeQuery = true)
    Long getSanPhamChiTietByIdSPAndIdSizeAndIdMauSac(@Param("idSanPham") Long idSanPham, @Param("idMauSac") Long idMauSac, @Param("idKichCo") Long idKichCo);
}
