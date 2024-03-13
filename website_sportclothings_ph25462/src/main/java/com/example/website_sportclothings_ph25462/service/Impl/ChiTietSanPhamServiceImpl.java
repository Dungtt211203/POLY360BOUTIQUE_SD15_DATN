package com.example.website_sportclothings_ph25462.service.Impl;


import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public Page<ChiTietSanPham> getData(Integer page) {
        Pageable pageable = PageRequest.of(page, 4);

        return chiTietSanPhamRepository.findAll(pageable);
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        return chiTietSanPhamRepository.findById(Long.getLong(id)).orElse(null);
    }

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public List<ChiTietSanPham> getCTSPByIdSanPham(long id) {
        return chiTietSanPhamRepository.getAllByIdSanPham(id);
    }

    @Override
    public ChiTietSanPham getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(long idSP, long idMauSac, long idKicCo) {
        return chiTietSanPhamRepository.getAllByIdSanPhamAndIdMauSacAndIdKichCo(idSP, idMauSac, idKicCo);
    }
}

