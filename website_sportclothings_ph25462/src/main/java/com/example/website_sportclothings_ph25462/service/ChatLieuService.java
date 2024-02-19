package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ChatLieu;
import com.example.website_sportclothings_ph25462.entity.KichCo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
@Service
public interface ChatLieuService {
    List<ChatLieu> getAll();

    ChatLieu add(ChatLieu chatLieu);

//    public ChatLieu createChatLieu(ChatLieu chatLieu) {
//        ChatLieu banner = new ChatLieu();
//        return bannerRepo.save(banner);
//    }

    void remove(UUID id);
}
