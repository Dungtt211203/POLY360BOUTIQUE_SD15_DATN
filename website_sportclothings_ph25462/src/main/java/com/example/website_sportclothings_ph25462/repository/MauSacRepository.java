package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    Page<MauSac> findAll(Pageable pageable);
}
