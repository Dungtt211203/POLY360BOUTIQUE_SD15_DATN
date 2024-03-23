package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAll();

    void remove(Long id);

    void save(ChiTietSanPham chiTietSP);

    Page<ChiTietSanPham> getData(Integer page);


    ChiTietSanPham getOne(Long id);

    Page<ChiTietSanPham> getAll(Pageable pageable);

    List<ChiTietSanPham> getCTSPByIdSanPham(long id);

    ChiTietSanPham getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(long idSP, long idMauSac, long idKchCo);


}
