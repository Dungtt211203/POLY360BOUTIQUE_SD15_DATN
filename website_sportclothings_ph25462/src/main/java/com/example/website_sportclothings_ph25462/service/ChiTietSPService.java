package com.example.website_sportclothings_ph25462.service;
import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface ChiTietSPService {

    List<ChiTietSanPham> getAll();

    void remove(Long id);
}
