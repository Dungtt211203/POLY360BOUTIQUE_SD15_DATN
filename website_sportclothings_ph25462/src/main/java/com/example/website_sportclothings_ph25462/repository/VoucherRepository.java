package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoucherRepository extends JpaRepository<Voucher, UUID> {
}
