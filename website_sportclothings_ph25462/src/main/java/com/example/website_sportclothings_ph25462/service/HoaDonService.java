package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface HoaDonService {

    public List<HoaDon> getAllByKhachHang();

//    Page<HoaDon> search(String keyword, Sort sort, Pageable pageable);

    public HoaDon add(HoaDon hoaDon);

    public HoaDon update(HoaDon hoaDon);

    public HoaDon getOne(Long id);

    public void delete(Long id);

    public List<HoaDon> getAllDonHangThanhCong();

    public List<HoaDon> getDonHangChoXacNhan();

    public List<HoaDon> getDonHangChoGiao();

    public List<HoaDon> getDonHangDangGiao();

    public List<HoaDon> getTatCaDonHang();

    public HoaDon getDonHangById(Long id);


}
