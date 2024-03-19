package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.*;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.repository.HoaDonChiTietRepository;
import com.example.website_sportclothings_ph25462.repository.HoaDonRepository;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private ChiTietSanPhamRepository chiTietSPRepository;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;


    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet getOne(Long id) {
        return hoaDonChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        hoaDonChiTietRepository.delete(getOne(id));
    }

    @Override
    public List<HoaDonChiTiet> getHDCTByIdHoaDon(long id) {
        return hoaDonChiTietRepository.getHoaDonChiTietByIdHoaDon(id);
    }

    @Override
    public HoaDon createOrder(KhachHang kh, String address, List<GioHangChiTiet> gioHangChiTietList, Long phiVanChuyen) {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        HoaDon hoaDon = new HoaDon();
        hoaDon.setKhachHang(kh);
        hoaDon.setDiaChiNguoiNhan(address);

        long total = 0;
        for (GioHangChiTiet gioHangChiTiet : gioHangChiTietList) {
            total += gioHangChiTiet.getSoLuong() * gioHangChiTiet.getChiTietSanPham().getGiaHienHanh(); // lấy tổng tiền
        }
        hoaDon.setTongTien(total + phiVanChuyen);
        hoaDon.setNgayTao(LocalDateTime.now());
        hoaDon.setLoaiHoaDon("Mua Online");
        hoaDon.setPhiGiaoHang(phiVanChuyen);
        hoaDon.setGiaPhaTra(total);
        hoaDon.setGhiChu("không...");
        hoaDon.setNguoiNhan(kh.getTen());
        hoaDon.setKhachHang(kh);
        hoaDon.setDiaChiNguoiNhan(address);
        hoaDon.setTaiKhoan(taiKhoan);


        hoaDon.setTrangThai(2); //  <!-- 2: Chờ Xác nhận, 3: Đã Xác nhận, 4: dang van chuyen, 1: thanh cong, 0: huy bo-->
//        hoaDon.setTrangThaiThanhToan(0); // trạng thái thanh toán hay chưa

        Long idMax = 0L; // lấy ID lớn nhất làm mã Đơn Hàng
        if (hoaDonRepository.gietIdMax() == null) {
            idMax = 1L;
        } else if (hoaDonRepository.gietIdMax() != null) {
            idMax = hoaDonRepository.gietIdMax() + 1;
        }
        hoaDon.setMaHoaDon("HD" + idMax.toString());

        hoaDonRepository.save(hoaDon);
        long maHDCT = idMax;
        for (GioHangChiTiet carts : gioHangChiTietList) {
            maHDCT += 1;
            HoaDonChiTiet orderDetail = new HoaDonChiTiet();
            orderDetail.setMaHoaDonChiTiet(String.valueOf(maHDCT));
            orderDetail.setHoaDon(hoaDon);
            orderDetail.setDonGia(carts.getChiTietSanPham().getGiaHienHanh());
            orderDetail.setSoLuong(carts.getSoLuong());
            orderDetail.setTrangThai(1);
            orderDetail.setGhiChu("Đặt Hàng Online! ");
            orderDetail.setNgayTao(LocalDateTime.now());
            orderDetail.setNgaySua(LocalDateTime.now());
            orderDetail.setNguoiSua("N/a");



            orderDetail.setChiTietSP(
                    chiTietSPRepository.findById(carts.getChiTietSanPham().getId()).orElse(null)
            );
//            orderDetail.setTrangThaiTraHang(0);

            HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.save(orderDetail);

        }

        return hoaDon;

    }
}


