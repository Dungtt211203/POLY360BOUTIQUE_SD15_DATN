package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import java.util.UUID;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {
=======
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Long> {

>>>>>>> hoanglc_PH27504
}
