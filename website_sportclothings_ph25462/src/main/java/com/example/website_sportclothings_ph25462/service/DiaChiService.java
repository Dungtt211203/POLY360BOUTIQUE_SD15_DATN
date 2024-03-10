package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.DiaChi;

public interface DiaChiService {

    public DiaChi addDiaChi( DiaChi diaChi);

    public DiaChi findAddressById(Long id);

    public DiaChi updateAddress(DiaChi address);

    public void deleteAddress(Long id);

    public void updateOtherAddressesToNonPrimary(Long khachHangId, Long currentAddressId);
}