package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.Voucher;
import com.example.website_sportclothings_ph25462.repository.VoucherRepository;
import com.example.website_sportclothings_ph25462.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    @Override
    public List<Voucher> getAll() {
        return voucherRepository.findAll();
    }

    @Override
    public void add(Voucher voucher) {
        voucherRepository.save(voucher);
    }
}
