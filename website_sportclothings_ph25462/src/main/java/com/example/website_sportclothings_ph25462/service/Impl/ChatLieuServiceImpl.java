package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.repository.ChatLieuRepository;
import com.example.website_sportclothings_ph25462.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    ChatLieuRepository clr;

    @Override
    public List<ChatLieu> getAll() {
        return clr.findAll();
    }

    @Override
    public ChatLieu add(ChatLieu chatLieu) {
        return clr.save(chatLieu);
    }

    @Override
    public ChatLieu update(Long id) {
        return clr.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        clr.deleteById(id);
    }

    @Override
    public Page<ChatLieu> search(String key, Pageable pageable) {
        return clr.search(key, pageable);
    }

    public ChatLieu getOne(String maCL) {
        return clr.getSanPhamByMaSP(maCL);
    }
}
