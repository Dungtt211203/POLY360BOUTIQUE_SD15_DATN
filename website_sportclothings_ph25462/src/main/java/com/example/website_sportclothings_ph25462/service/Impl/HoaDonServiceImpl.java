package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.HoaDon;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.HoaDonRepository;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {


    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;


    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public List<HoaDon> getAllByKhachHang() {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        return hoaDonRepository.getAllHDByKhachHang(taiKhoan.getId());
    }
//    public Page<HoaDon> search(String keyword,Sort sort, Pageable pageable) {
//        return hoaDonRepository.findByMaHoaDonContaining(keyword, sort,pageable);
//    }

//    public Page<HoaDon> searchAndSort(String keyword, String sortBy, String direction, Pageable pageable) {
//        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
//        Sort sort = Sort.by(sortDirection, sortBy);
//        Pageable sortedPageable = PageRequest.of(pageable, sort);
//        return hoaDonRepository.findByMaHoaDonContaining(keyword, sortedPageable);
//    }

    @Override
    public HoaDon add(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon update(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon getOne(Long id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        hoaDonRepository.delete(getOne(id));
    }

    @Override
    public List<HoaDon> getAllDonHangThanhCong() {
        return hoaDonRepository.getDonHangThanhCong();
    }

    @Override
    public List<HoaDon> getDonHangChoXacNhan() {
        return hoaDonRepository.getDonHangChoXacNhan();
    }

    @Override
    public List<HoaDon> getDonHangChoGiao() {
        return hoaDonRepository.getDonHangChoGiao();
    }

    @Override
    public List<HoaDon> getDonHangDangGiao() {
        return hoaDonRepository.getDonHangDangGiao();
    }

    @Override
    public HoaDon getDonHangById(Long id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

}
