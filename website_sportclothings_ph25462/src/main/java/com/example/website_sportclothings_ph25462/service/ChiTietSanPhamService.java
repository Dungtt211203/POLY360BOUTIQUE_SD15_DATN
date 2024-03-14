package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChiTietSanPhamService {

    Page<ChiTietSanPham> getData(Integer page);

    ChiTietSanPham getOne(String id);

    List<ChiTietSanPham> getAll();

    List<ChiTietSanPham> getCTSPByIdSanPham(long id);

    ChiTietSanPham getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(long idSP, long idMauSac, long idKchCo);

    void save(ChiTietSanPham chiTietSP);
}
