package com.example.website_sportclothings_ph25462.repository;


import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HinhAnhSPRepository extends JpaRepository<HinhAnhSP, UUID> {
}
