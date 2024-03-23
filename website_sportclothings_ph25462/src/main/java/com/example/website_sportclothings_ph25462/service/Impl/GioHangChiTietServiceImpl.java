package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.*;
import com.example.website_sportclothings_ph25462.repository.GioHangChiTietRepository;
import com.example.website_sportclothings_ph25462.repository.GioHangRepository;
import com.example.website_sportclothings_ph25462.repository.KhachHangRepository;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.GioHangChiTietService;
import com.example.website_sportclothings_ph25462.service.GioHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;

    @Autowired
    private HttpSession session;

//    @Autowired
//    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private GioHangService gioHangService;

//    @Autowired
//    private ChiTietSPService chiTietSanPhamService;


    @Override
    public List<GioHangChiTiet> getAllByKhachHang(KhachHang khachHang) {

        GioHang gioHang = gioHangRepository.getAllByKhachHang(khachHang);
        if (gioHang == null) {
            gioHang = gioHangService.kiemTraGioHangCuaKhachHang(khachHang);

        }

        return gioHangChiTietRepository.getGioHangChiTietByIdGioHang(gioHang.getId());
    }

    @Override
    public List<GioHangChiTiet> getAll() {
        return gioHangChiTietRepository.findAll();
    }

    @Override
    public GioHangChiTiet add(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet update(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public void delete(Long id) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(id).orElse(null);
        gioHangChiTietRepository.delete(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet getGioHangChiTietByIdGioHangAndIdCTSP(long idGioHang, long idSPCT) {
        return gioHangChiTietRepository.getGioHangChiTietByGioHangAndAndSanPhamChiTiet(idGioHang, idSPCT);
    }

    @Override
    public GioHangChiTiet getOne(Long id) {
        return gioHangChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public void loginAddToCart() {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        try {

            if (taiKhoan != null) {
                KhachHang khachHang = khachHangRepository.getKhachHangByIdTaiKhoan(taiKhoan.getId());
                //list sản phẩm trong session
                List<GioHangChiTiet> carts = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");

                if (carts != null) {

                    for (GioHangChiTiet item : carts) {

//                        Integer idMauSac = mauSacRepository.getMauSacByTen(item.getProductColor()).getId();
//                        Integer idKichCo = kichCoRepository.getKichCoByTen(item.getProductSize()).getId();

                        ChiTietSanPham chiTietSanPham = item.getChiTietSanPham();
                        System.out.printf("có id ccccccccc " + chiTietSanPham.getId());

                        //    tìm giỏ hàng chi tiết xem đã có hay chưa
                        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository
                                .getGioHangChiTietByGioHangAndAndSanPhamChiTiet(gioHangService.kiemTraGioHangCuaKhachHang(khachHang).getId(), chiTietSanPham.getId());

                        if (gioHangChiTiet == null) {
                            GioHangChiTiet gioHangCT = new GioHangChiTiet();

                            gioHangCT.setGioHang(gioHangService.kiemTraGioHangCuaKhachHang(khachHang));
                            gioHangCT.setChiTietSanPham(chiTietSanPham); //
                            gioHangCT.setSoLuong(item.getSoLuong());
                            gioHangChiTietRepository.save(gioHangCT);

                        }

                        if (gioHangChiTiet != null) {
                            GioHangChiTiet gioHangCT = gioHangChiTiet;

                            Integer soLuongMoi = item.getSoLuong();
                            Integer soLuongCu = gioHangChiTiet.getSoLuong();
                            gioHangCT.setSoLuong(soLuongCu + soLuongMoi);
                            gioHangChiTietRepository.save(gioHangChiTiet);
                        }

                    }
                    // sau khi lưu vào DB xóa session carts
                    session.removeAttribute("carts");
                    System.out.printf("Đã Xóa sp trong cart session. ///");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void clearAll(long idGioHang) {
        gioHangChiTietRepository.deleteAllByIdGioHang(idGioHang);
    }


}
