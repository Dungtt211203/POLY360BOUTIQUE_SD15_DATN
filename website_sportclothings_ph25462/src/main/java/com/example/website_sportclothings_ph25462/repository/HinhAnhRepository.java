package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HinhAnhRepository extends JpaRepository<HinhAnh, UUID> {
}
