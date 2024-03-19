package com.example.website_sportclothings_ph25462.controller;


import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.DiaChiRepository;
import com.example.website_sportclothings_ph25462.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DiaChiController {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private DiaChiRepository diaChiRepository;

    @Autowired
    private DiaChiService diaChiService;


    @PostMapping("/create_address")
    public String createAddress(@ModelAttribute("address") DiaChi diaChi) {
        TaiKhoan taiKhoanKH = taiKhoanRepository.findById(1L).orElse(null);

        List<DiaChi> diaChiList = diaChiRepository.findAll();

        diaChi.setTaiKhoanKH(taiKhoanKH);

        diaChi.setTinh(diaChi.getThanhPho());
        diaChi.setMa("DC" + diaChiRepository.idMax() + 1);
        if (diaChiList.isEmpty()) {
            diaChi.setTrangThai(1);
            diaChiService.addDiaChi(diaChi);
        }
        if (diaChi.getTrangThai() == null) {
            diaChi.setTrangThai(0);
            diaChiService.addDiaChi(diaChi);
        } else if (diaChi.getTrangThai() == 1) {
            diaChi.setTrangThai(1);

            diaChiService.addDiaChi(diaChi);

            diaChiService.updateOtherAddressesToNonPrimary(1L, diaChi.getId());

        }


        return "redirect:/checkout/show";
    }

}
