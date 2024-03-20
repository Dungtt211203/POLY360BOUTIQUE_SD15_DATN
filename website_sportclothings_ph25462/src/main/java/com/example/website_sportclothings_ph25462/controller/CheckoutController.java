package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.entity.HoaDon;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.DiaChiRepository;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.GioHangChiTietService;
import com.example.website_sportclothings_ph25462.service.HoaDonChiTietService;
import com.example.website_sportclothings_ph25462.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

//    @Autowired
//    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private DiaChiRepository diaChiRepository;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private HttpSession session;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;

    @ModelAttribute("principal")
    public TaiKhoan principal() {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        return taiKhoan;
    }

    @GetMapping("/show")
    public String showCheckout(Model model) {
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        if (taiKhoan == null) {
            return "redirect:/login";
        }
        try {
            model.addAttribute("diaChiList", diaChiRepository.getAllByKH(taiKhoan.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/checkout/checkout";
    }


    @PostMapping("/process")
    public String processCheckout(@RequestParam String address, String shippingFee, Model model) {

//        try {
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        if (taiKhoan == null) {
            return "redirect:/login";
        }

        KhachHang khachHang = khachHangService.getKHByIdTaiKhoan(taiKhoanDangDangNhap.getCurrentNguoiDung().getId());
        List<GioHangChiTiet> carts = gioHangChiTietService.getAllByKhachHang(khachHang);

        if (carts != null && !carts.isEmpty()) {
            Long phiVanChuyen = 30000L; // tạm để mạc định phí GH = 30k
            try {
                System.out.printf("zzzzzzzzzzzzzzz tới đây z trong cart "+ address);
                phiVanChuyen = Long.parseLong(shippingFee);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // tạo một đối tượng DonHang mới và lưu vào cơ sở dữ liệu
            HoaDon order = hoaDonChiTietService.createOrder(khachHang, address, carts, phiVanChuyen);

//             Xóa giỏ hàng
            gioHangChiTietService.clearAll(carts.get(0).getGioHang().getId());

            model.addAttribute("order", order);

            return "redirect:/checkout/success/" + order.getId();
        } else {
            System.out.printf("zzzzzzzzzzzzzzz tới đây ngoài "+ address);
            return "redirect:/checkout/show";
        }
    }


    @GetMapping("/success/{idHD}")
    public String showCheckoutSuccess(Model model, @PathVariable long idHD) {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        if (taiKhoan == null) {
            return "redirect:/login";
        }

        model.addAttribute("idHD", idHD);

        return "/checkout/checkout-success";

    }


    @ModelAttribute(name = "carts")
    public List<GioHangChiTiet> cartItems(Model model) {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();


        if (taiKhoan != null) {
            KhachHang khachHang = khachHangService.getKHByIdTaiKhoan(taiKhoan.getId());
            System.out.printf("KH " + khachHang.getTen());
            List<GioHangChiTiet> gioHangChiTietDB = gioHangChiTietService.getAllByKhachHang(khachHang);
            Long totalAmount = 0L;

            if (gioHangChiTietDB.size() > 0) {

                for (GioHangChiTiet gioHangChiTiet : gioHangChiTietDB) {
                    totalAmount += (gioHangChiTiet.getSoLuong() * gioHangChiTiet.getChiTietSanPham().getGiaHienHanh());
                }
                model.addAttribute("totalAmount", totalAmount);
            }
            return gioHangChiTietDB;
        }
        List<GioHangChiTiet> gioHangChiTietList = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");

        return gioHangChiTietList;
    }


}
