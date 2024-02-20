package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
}
