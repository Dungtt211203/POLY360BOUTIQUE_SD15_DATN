package com.example.website_sportclothings_ph25462.service;
import com.example.website_sportclothings_ph25462.entity.DiaChi;
import org.springframework.stereotype.Service;

@Service
public interface DiaChiService {

    DiaChi addDiaChi( DiaChi diaChi);

    DiaChi findAddressById(Long id);

    DiaChi updateAddress(DiaChi address);

    void deleteAddress(Long id);

    void updateOtherAddressesToNonPrimary(Long khachHangId, Long currentAddressId);
}


