package com.example.website_sportclothings_ph25462.service.Impl;


import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepository chiTietSPRepository;

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSPRepository.findAll();

    }

    @Override
    public void remove(Long id) {

        chiTietSPRepository.deleteById(id);
    }

    @Override
    public void save(ChiTietSanPham chiTietSP) {
        chiTietSPRepository.save(chiTietSP);
    }


    @Override
    public Page<ChiTietSanPham> getData(Integer page) {
        Pageable pageable = PageRequest.of(page, 1);
        return chiTietSPRepository.findAll(pageable);
    }

    @Override

    public ChiTietSanPham getOne(Long id) {
        return chiTietSPRepository.findById(id).orElse(null);
    }


    @Override
    public List<ChiTietSanPham> getCTSPByIdSanPham(long id) {
        return chiTietSPRepository.getAllByIdSanPham(id);
    }

    //    @Override
//    public ChiTietSP getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(long idSP, long idMauSac, long idKicCo) {
//        return null;
//    }
    @Override
    public Page<ChiTietSanPham> getAll(Pageable pageable) {
        return chiTietSPRepository.findAll(pageable);
    }

    @Override
    public ChiTietSanPham getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(Long idSP, Long idMauSac, Long idKicCo) {
        return chiTietSPRepository.getAllByIdSanPhamAndIdMauSacAndIdKichCo(idSP, idMauSac, idKicCo);
    }
}

