package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import com.example.website_sportclothings_ph25462.service.GioHangChiTietService;
import com.example.website_sportclothings_ph25462.service.GioHangService;
import com.example.website_sportclothings_ph25462.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class KiemTraSLSanPhamController {
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    private TaiKhoanDangDangNhap khachHangDangDangNhap;
    @Autowired
    private ChiTietSanPhamRepository sanPhamChiTietService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    GioHangService gioHangService;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    GioHangChiTietService gioHangChiTietService;

    @GetMapping("/chitietsp/kiemTraSoLuongSanPham/{idSanPham}/{idMauSac}/{idKichCo}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> kiemTraSoLuongSanPham(@PathVariable("idSanPham") Long idSanPham,
                                                                     @PathVariable("idMauSac") Long idMauSac, @PathVariable("idKichCo") Long idKichCo) {
        System.out.printf("ok dến đây zoi zzzzzz" + idSanPham + "/ " + idKichCo);
        Map<String, Object> response = new HashMap<>();
        Long soLuongSPConLai = 0L;
        try {
            soLuongSPConLai = chiTietSanPhamRepository.getSanPhamChiTietByIdSPAndIdSizeAndIdMauSac(idSanPham, idMauSac, idKichCo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("xxxxxxxxxxxxxxxx " + soLuongSPConLai);
        if (soLuongSPConLai == null) {
            soLuongSPConLai = 0L;
        }


        response.put("soLuongSPConLai", soLuongSPConLai);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @GetMapping("/giaBan/{idSanPham}")
    public ResponseEntity<Long> getGiaBanByIdSanPham(@PathVariable long idSanPham) {
        ChiTietSanPham chiTietSanPham = sanPhamChiTietService.getGiaSanPhamMinById(idSanPham);

        if (chiTietSanPham != null) {
            Long giaBan = chiTietSanPham.getGiaHienHanh();
            return ResponseEntity.ok(giaBan);
        } else {
            // Trả về mã trạng thái 404 nếu không tìm thấy sản phẩm chi tiết
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/giaGoc/{idSanPham}")
    public ResponseEntity<Long> getGiaGocByIdSanPham(@PathVariable long idSanPham) {
        ChiTietSanPham chiTietSanPham = sanPhamChiTietService.getGiaSanPhamMinById(idSanPham);

        if (chiTietSanPham != null) {
            Long giaGoc = chiTietSanPham.getGiaGoc();
            return ResponseEntity.ok(giaGoc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buyNow/{idSanPham}/{idMauSac}/{idKichCo}/{SoLuong}")
    public String hienThiBuyNow(@PathVariable("idSanPham") Long idSanPham, @PathVariable("idMauSac") Long idMauSac,
                                @PathVariable("idKichCo") Long idKichCo, @PathVariable("SoLuong") Integer soLuong) {
        TaiKhoan taiKhoan = khachHangDangDangNhap.getCurrentNguoiDung();
        if (taiKhoan == null) {
            return "redirect:/login";
        }
        if (taiKhoan != null) {

            KhachHang khachHang = khachHangService.getKHByIdTaiKhoan(taiKhoan.getId());

            long idGioHang = gioHangService.kiemTraGioHangCuaKhachHang(khachHang).getId();
            long idSPCT = chiTietSanPhamService.getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(idSanPham, idMauSac, idKichCo).getId();
            GioHangChiTiet gioHangChiTiet = gioHangChiTietService.getGioHangChiTietByIdGioHangAndIdCTSP(idGioHang, idSPCT);
            if (gioHangChiTiet == null) {
                gioHangChiTiet = new GioHangChiTiet();
                gioHangChiTiet.setSoLuong(soLuong);
                ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(idSanPham, idMauSac, idKichCo);
                gioHangChiTiet.setChiTietSanPham(chiTietSanPham); //
                gioHangChiTiet.setGioHang(gioHangService.kiemTraGioHangCuaKhachHang(khachHang));
                gioHangChiTietService.add(gioHangChiTiet);
                return "redirect:/checkout/show";

            }
            gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + soLuong); // số lượng cũ cộng số lượng mới
            gioHangChiTietService.add(gioHangChiTiet);
            return "redirect:/checkout/show";
        }
        return "redirect:/checkout/show";
    }

}
