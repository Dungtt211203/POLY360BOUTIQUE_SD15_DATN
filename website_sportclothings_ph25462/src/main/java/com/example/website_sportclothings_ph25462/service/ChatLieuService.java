package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.KichCo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface ChatLieuService {
    List<ChatLieu> getAll();

    void add(ChatLieu chatLieu);

    void remove(Long id);
}
