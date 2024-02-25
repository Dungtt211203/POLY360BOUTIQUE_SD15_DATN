package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, Long> {
    @Query("SELECT cl FROM ChatLieu cl where cl.ten LIKE %?1% or cl.ma like %?1%")
    Page<ChatLieu> search(String key, Pageable pageable);

    @Query("select cl from ChatLieu cl where  cl.ma =?1")
    ChatLieu getSanPhamByMaSP(String maCl);
}
