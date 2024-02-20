package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.repository.ChatLieuRepository;
import com.example.website_sportclothings_ph25462.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
    public ChatLieu update(UUID id) {
        return clr.findById(id).orElse(null);
    }

    @Override
    public void remove(UUID id) {
        clr.deleteById(id);
    }
}
