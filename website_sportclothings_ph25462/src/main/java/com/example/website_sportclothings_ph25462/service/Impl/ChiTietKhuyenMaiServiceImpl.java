package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.repository.ChiTietKhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.repository.KhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietKhuyenMaiServiceImpl implements ChiTietKhuyenMaiService {

    @Autowired
    ChiTietKhuyenMaiRepository chiTietKhuyenMaiRepository;

    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Autowired
    ChiTietSanPhamRepository chiTietSPRepository;

    @Override
    public List<ChiTietKhuyenMai> getAll() {

        return chiTietKhuyenMaiRepository.findAll();
    }


//    @Override
//    public ChiTietKhuyenMai add(ChiTietKhuyenMai chiTietKhuyenMai) {
//        chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
//        Optional<KhuyenMai> khuyenMaiOptional = khuyenMaiRepository.findById(chiTietKhuyenMai.getKhuyenMai().getId());
//        if (khuyenMaiOptional.isPresent()) {
//            KhuyenMai khuyenMai = khuyenMaiOptional.get();
//            Integer trangThai = Math.toIntExact(khuyenMai.getTrangThai());
//            if (trangThai != null && trangThai == 1) {
//                for (ChiTietKhuyenMai ctkm : khuyenMai.getChiTietKhuyenMaiList()) {
//                    Optional<ChiTietSP> chiTietSPOptional = chiTietSPRepository.findById(ctkm.getChiTietSP().getId());
//                    if (chiTietSPOptional.isPresent()) {
//                        ChiTietSP chiTietSP = chiTietSPOptional.get();
//                        if (chiTietKhuyenMai.getHinhThucGiam() == 1) {
//                            chiTietSP.setGiaHienHanh((long) (chiTietSP.getGiaGoc() * (100 - chiTietKhuyenMai.getGiaTriGiam()) / 100));
//                        }
//                        chiTietSPRepository.save(chiTietSP);
//                    }
//                }
//            }
//        }
//        return chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
//    }

    @Override

    public ChiTietKhuyenMai add(ChiTietKhuyenMai chiTietKhuyenMai) {
        chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
        Optional<KhuyenMai> khuyenMaiOptional = khuyenMaiRepository.findById(chiTietKhuyenMai.getKhuyenMai().getId());
        Integer trangThai = Math.toIntExact(khuyenMaiOptional.get().getTrangThai());
        if (trangThai != null && trangThai == 2) {
            for (ChiTietKhuyenMai ctkm : khuyenMaiOptional.get().getChiTietKhuyenMaiList()) {
                Optional<ChiTietSanPham> chiTietSPOptional = chiTietSPRepository.findById(ctkm.getChiTietSP().getId());
                if (ctkm.getHinhThucGiam() == 1) {
                    chiTietSPOptional.get().setGiaHienHanh((long) (chiTietSPOptional.get().getGiaGoc() * (100 - ctkm.getGiaTriGiam()) / 100));
                }
                chiTietSPRepository.save(chiTietSPOptional.get());
            }
        }
        return chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);

    }

    @Override

    public ChiTietKhuyenMai update(ChiTietKhuyenMai chiTietKhuyenMai, Long id) {
        chiTietKhuyenMai.setId(id);
        chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
        Optional<KhuyenMai> khuyenMaiOptional = khuyenMaiRepository.findById(chiTietKhuyenMai.getKhuyenMai().getId());
        Integer trangThai = Math.toIntExact(khuyenMaiOptional.get().getTrangThai());
        if (trangThai != null && trangThai == 2) {
            for (ChiTietKhuyenMai ctkm : khuyenMaiOptional.get().getChiTietKhuyenMaiList()) {
                Optional<ChiTietSanPham> chiTietSPOptional = chiTietSPRepository.findById(ctkm.getChiTietSP().getId());
                if (ctkm.getHinhThucGiam() == 1) {
                    chiTietSPOptional.get().setGiaHienHanh((long) (chiTietSPOptional.get().getGiaGoc() * (100 - ctkm.getGiaTriGiam()) / 100));
                }
                chiTietSPRepository.save(chiTietSPOptional.get());
            }
        }
        return chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
    }

    @Override
    public ChiTietKhuyenMai getChiTietKhuyenMaiById(Long id) {
        return chiTietKhuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public ChiTietKhuyenMai getOne(String maCtkm) {
        return chiTietKhuyenMaiRepository.getChiTietKhuyenMaiBy(maCtkm);
    }

    @Override
    public Page<ChiTietKhuyenMai> getAll(Pageable pageable) {
        return chiTietKhuyenMaiRepository.findAll(pageable);
    }

    @Override
    public void remove(Long id) {
        chiTietKhuyenMaiRepository.deleteById(id);
    }
}
