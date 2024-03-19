package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.DiaChi;
import com.example.website_sportclothings_ph25462.repository.DiaChiRepository;
import com.example.website_sportclothings_ph25462.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaChiServiceImpl implements DiaChiService {

    @Autowired
    private DiaChiRepository diaChiRepository;

    @Override
    public DiaChi addDiaChi(DiaChi diaChi) {
        return diaChiRepository.save(diaChi);
    }

    @Override
    public DiaChi findAddressById(Long id) {
        return diaChiRepository.findById(id).orElse(null);
    }

    @Override
    public DiaChi updateAddress(DiaChi diaChi) {
        return diaChiRepository.save(diaChi);
    }

    @Override
    public void deleteAddress(Long id) {

    }

    @Override
    public void updateOtherAddressesToNonPrimary(Long khachHangId, Long currentAddressId) {
        diaChiRepository.updateAllAddressesToNonPrimary(khachHangId, currentAddressId);
    }
}
