package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, UUID> {
}
