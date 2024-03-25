package com.example.website_sportclothings_ph25462.controller.admin;

import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.HoaDon;
import com.example.website_sportclothings_ph25462.entity.HoaDonChiTiet;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.repository.HoaDonChiTietRepository;
import com.example.website_sportclothings_ph25462.request.HuyDonHangRequest;
import com.example.website_sportclothings_ph25462.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
@Controller
@RequestMapping("/admin/donHang")
public class DonHangAdminController {
    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private ChiTietSanPhamRepository chiTietSPRepository;

    @GetMapping("/tatCaDonHang")
    public String tatCaDonHang(Model model) {

        model.addAttribute("tatCaDonHang", hoaDonService.getTatCaDonHang());

        return "/admin/don_hang/tatcaDonHang";
    }
    @GetMapping("/donHangCho")
    public String donHangCho(Model model) {

        model.addAttribute("donHangChoXacNhan", hoaDonService.getDonHangChoXacNhan());

        return "/admin/don_hang/xacNhanDonHang";
    }


    @GetMapping("/donHangChoGiao")
    public String donHangChoGiao(Model model) {

        model.addAttribute("donHangChoGiao", hoaDonService.getDonHangChoGiao());

        return "/admin/don_hang/donHangChoGiao";
    }

    @GetMapping("/donHangDangGiao")
    public String donHangDangGiao(Model model) {

        model.addAttribute("donHangDangGiao", hoaDonService.getDonHangDangGiao());

        return "/admin/don_hang/donHangDangGiao";
    }


    @PostMapping("/xacNhan")
    public String xacNhanDonHang(@RequestBody List<Long> selectedItems) {

        for (int i = 0; i < selectedItems.size(); i++) {
            HoaDon donHang = hoaDonService.getDonHangById(selectedItems.get(i));

            List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.findDonHangChiTietByIdDonHang(donHang.getId());
            for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {
                if (hoaDonChiTiet.getChiTietSP().getSoLuong() < hoaDonChiTiet.getSoLuong()) {
                    return "0";
                }

                if (hoaDonChiTiet.getId() != null) {
                    donHang.setTrangThai(3);
                    ChiTietSanPham chiTietSP = chiTietSPRepository.findById(hoaDonChiTiet.getChiTietSP().getId()).orElse(null);
                    chiTietSP.setSoLuong(chiTietSP.getSoLuong() - hoaDonChiTiet.getSoLuong());
                    chiTietSPRepository.save(chiTietSP);

                }
            }

            hoaDonService.update(donHang);

        }

        return "redirect:/admin/donHang/donHangCho";
    }

    @PostMapping("/XacNhanDonHangChoGiao")
    public String xacNhanDonHangChoGiao(@RequestBody List<Long> selectedItems) {

        for (int i = 0; i < selectedItems.size(); i++) {
            HoaDon hoaDon = hoaDonService.getDonHangById(selectedItems.get(i));
            hoaDon.setTrangThai(4);
            hoaDonService.update(hoaDon);
        }

        return "redirect:/admin/donHang/donHangChoGiao";
    }


    // giao thành công
    @PostMapping("/xacNhanDonHangDangGiao")
    public String XacNhanDonHanDangGiao(@RequestBody List<Long> selectedItems) {

        for (int i = 0; i < selectedItems.size(); i++) {
            HoaDon hoaDon = hoaDonService.getDonHangById(selectedItems.get(i));
            hoaDon.setTrangThai(1);
            hoaDonService.update(hoaDon);
        }

        return "redirect:/admin/donHang/donHangDangGiao";
    }


    @PostMapping("/huyXacNhan")
    public String huyXacNhanDonHang(@RequestBody HuyDonHangRequest huyDonHangRequest) {

        try {
            for (int i = 0; i < huyDonHangRequest.getSelectedItems().size(); i++) {
                HoaDon hoaDon = hoaDonService.getDonHangById(huyDonHangRequest.getSelectedItems().get(i));
                hoaDon.setGhiChu(huyDonHangRequest.getLyDo());
                List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.findDonHangChiTietByIdDonHang(hoaDon.getId());
                for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {

                    if (hoaDonChiTiet.getId() != null) {
                        if (hoaDon.getTrangThai() != 2) {
                            System.out.printf("xxxxxxxx trang thái" + hoaDon.getTrangThai());
                            ChiTietSanPham chiTietSP = chiTietSPRepository.findById(hoaDonChiTiet.getChiTietSP().getId()).orElse(null);
                            chiTietSP.setSoLuong(chiTietSP.getSoLuong() + hoaDonChiTiet.getSoLuong());
                            chiTietSPRepository.save(chiTietSP);
                        }

                    }
                }
                hoaDon.setTrangThai(0);
                hoaDonService.update(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "redirect:/admin/donHang/donHangCho";
    }


    @GetMapping("/{idDonHang}")
    public String orderDetail(Model model, @PathVariable long idDonHang) {
        try {

            List<HoaDonChiTiet> donHangChiTietList = hoaDonChiTietRepository.getHoaDonChiTietByIdHoaDon(idDonHang);
            model.addAttribute("donHangChiTietList", donHangChiTietList);
            model.addAttribute("maDonHang", donHangChiTietList.get(0).getHoaDon().getMaHoaDon());
            model.addAttribute("tongTien", donHangChiTietList.get(0).getHoaDon().getTongTien());
            model.addAttribute("trangThai", donHangChiTietList.get(0).getHoaDon().getTrangThai());
            model.addAttribute("idDonHang", idDonHang);
            return "/admin/don_hang/donHangChiTiet";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin/do_hang/donHangChiTiet";
    }

    @GetMapping("/thanhCong/{idDonHang}")
    public String donHanThanhCongCT(Model model, @PathVariable long idDonHang) {
        try {

            List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.getHoaDonChiTietByIdHoaDon(idDonHang);
            model.addAttribute("donHangChiTietList", hoaDonChiTietList);
            model.addAttribute("maDonHang", hoaDonChiTietList.get(0).getHoaDon().getMaHoaDon());
            model.addAttribute("tongTien", hoaDonChiTietList.get(0).getHoaDon().getTongTien());
            model.addAttribute("trangThai", hoaDonChiTietList.get(0).getHoaDon().getTrangThai());
            model.addAttribute("idDonHang", idDonHang);
            return "/admin/don_hang/donHangThanhCongCT";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin/don_hang/donHangThanhCongCT";
    }


    // hủy ở đơn hàng chi Tiết
    @GetMapping("/huyXacNhan/{idDonHang}")
    public String huyXacNhanDonHangChiTiet(@PathVariable Long idDonHang, @RequestParam("lyDo") String lyDo) {
        System.out.printf("xxxxxxxxxxxxxx Ly DO:  " + lyDo);
        HoaDon hoaDon = hoaDonService.getDonHangById(idDonHang);

        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.findDonHangChiTietByIdDonHang(hoaDon.getId());
        for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {
            if (hoaDonChiTiet.getId() != null) {
                if (hoaDon.getTrangThai() != 2) {
                    System.out.printf("xxxxxxxx trang thái" + hoaDon.getTrangThai());
                    ChiTietSanPham chiTietSP = chiTietSPRepository.findById(hoaDonChiTiet.getChiTietSP().getId()).orElse(null);
                    chiTietSP.setSoLuong(chiTietSP.getSoLuong() + hoaDonChiTiet.getSoLuong());
                    chiTietSPRepository.save(chiTietSP);
                }

            }
        }
        hoaDon.setGhiChu(lyDo);
        hoaDon.setTrangThai(0);
        hoaDonService.update(hoaDon);

        return "redirect:/admin/donHang/donHangCho";
    }

    @GetMapping("/xacNhan/{idDonHang}")
    public String xacNhanDonHangChiTiet(@PathVariable Long idDonHang) {

        System.out.printf("//////  " + idDonHang    );
        HoaDon hoaDon = hoaDonService.getDonHangById(idDonHang);
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.findDonHangChiTietByIdDonHang(hoaDon.getId());
        for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {
            if (hoaDonChiTiet.getChiTietSP().getSoLuong() < hoaDonChiTiet.getSoLuong()) {
                return "0";
            }

            if (hoaDonChiTiet.getId() != null) {
                hoaDon.setTrangThai(3);
                ChiTietSanPham chiTietSP = chiTietSPRepository.findById(hoaDonChiTiet.getChiTietSP().getId()).orElse(null);
                chiTietSP.setSoLuong(chiTietSP.getSoLuong() - hoaDonChiTiet.getSoLuong());
                chiTietSPRepository.save(chiTietSP);
                hoaDonService.update(hoaDon);
            }
        }


        return "redirect:/admin/donHang/donHangCho";
    }

    @GetMapping("/donHangChoGiao/{idDonHang}")
    public String xacNhanDonHangChoGiao(@PathVariable Long idDonHang) {
        HoaDon hoaDon = hoaDonService.getDonHangById(idDonHang);
        hoaDon.setTrangThai(4);
        hoaDonService.update(hoaDon);

        return "redirect:/admin/donHang/donHangCho";
    }

    @GetMapping("/donHangDangGiao/{idDonHang}")
    public String xacNhanDonHangDangGiao(@PathVariable Long idDonHang) {
        System.out.printf("xxxxxxx tới giao t công "+ idDonHang);
        HoaDon hoaDon = hoaDonService.getDonHangById(idDonHang);
        hoaDon.setNgayThanhToan(LocalDateTime.now());
        hoaDon.setTrangThai(1);
        hoaDonService.update(hoaDon);

        return "redirect:/admin/donHang/donHangCho";
    }
}
