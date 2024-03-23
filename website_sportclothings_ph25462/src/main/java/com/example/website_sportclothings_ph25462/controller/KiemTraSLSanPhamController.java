package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
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
    private ChiTietSanPhamRepository sanPhamChiTietService;


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


}
