package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {
}
