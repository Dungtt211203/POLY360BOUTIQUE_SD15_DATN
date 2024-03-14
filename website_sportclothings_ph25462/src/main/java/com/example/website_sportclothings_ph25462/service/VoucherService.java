package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.Voucher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoucherService {
    List<Voucher> getAll();

    void add(Voucher voucher);
}
