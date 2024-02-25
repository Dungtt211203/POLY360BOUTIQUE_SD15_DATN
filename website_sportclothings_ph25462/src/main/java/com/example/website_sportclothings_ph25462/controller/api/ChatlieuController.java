//package com.example.website_sportclothings_ph25462.controller.api;
//
//import com.example.website_sportclothings_ph25462.entity.ChatLieu;
//import com.example.website_sportclothings_ph25462.repository.ChatLieuRepository;
//import com.example.website_sportclothings_ph25462.service.ChatLieuService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/api/v1")
//@RequiredArgsConstructor
//@Slf4j
//public class ChatlieuController {
//    @Autowired
//    ChatLieuRepository clr;
//    @Autowired
//    ChatLieuService chatLieuService;
//
//    @GetMapping("/chatlieu")
//    public ResponseEntity<List<ChatLieu>> chatlieu() {
//        List<ChatLieu> chatlieuData = chatLieuService.getAll();
//
//        return ResponseEntity.ok(chatlieuData);
//    }
//
//    @PostMapping(value = "/chatlieu", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<ChatLieu> creatNewChatlieu(
//            @RequestBody ChatLieu chatLieu
//    ) {
//        return ResponseEntity.ok(chatLieuService.add(chatLieu));
//    }
//
//}
