package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.service.VNPayService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VNPayController {
    @Autowired
    private VNPayService vnPayService;


    @GetMapping("")
    public String home() {
        return "index";
    }

    @PostMapping("/submitOrder")
    public String submidOrder(@RequestParam("amount") Long orderTotal,
                              @RequestParam("orderInfo") String orderInfo,
                              HttpServletRequest request) {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
        return "redirect:" + vnpayUrl;
    }

    @GetMapping("/vnpay-payment")
    public String GetMapping(HttpServletRequest request, Model model) {
        int paymentStatus = vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);

        return paymentStatus == 1 ? "ordersuccess" : "orderfail";
    }
//    Cách 2 test sau
// THANH TOÁN VNPAY
//@Autowired
//private VnPayServiceImpl vnPayService;
//
//
//    @GetMapping("/VnPay")
//    public String home(Model model) {
//        Double price = gioHangChiTietService.getTotalMoney(listGHCT);
//        Integer amount = price.intValue();
//        model.addAttribute("amount", amount);
//        System.out.println("Tổng tiền" +amount);
//        return "VnPay/index";
//    }
//
//    @PostMapping("/submitOrder")
//    public String submidOrder(@RequestParam("amount") Long orderTotal,
//                              @RequestParam("orderInfo") String orderInfo,
//                              HttpServletRequest request) {
//
//        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
//        String vnpayUrl = vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
//        return "redirect:" + vnpayUrl;
//    }
//
//    @GetMapping("/vnpay-payment")
//    public String GetMapping(HttpServletRequest request, Model model) throws ParseException {
//        int paymentStatus = vnPayService.orderReturn(request);
//        if (paymentStatus == 1) {
//            hoaDon.setPhuongThucThanhToan(2);
//            hoaDon.setTrangThai(2);
//            hoaDonService.saveHoaDon(hoaDon);
//            // Tạo hóa đơn chi tiết
//            for (GioHangChiTiet ghct : listGHCT) {
//                HoaDonChiTiet hdct = new HoaDonChiTiet();
//                hdct.setHoaDon(hoaDon);
//                hdct.setChiTietSanPham(ghct.getCtsp());
//                hdct.setSoLuong(ghct.getSoLuong());
//                if (ghct.getCtsp().getCtkm() != null) {
//                    double donGiaKhiGiam = 0;
//                    Boolean allTrangThai1 = false;
//                    for (ChiTietKhuyenMai chiTietKhuyenMai : ghct.getCtsp().getCtkm()) {
//                        if (chiTietKhuyenMai.getTrangThai() == 0) {
//                            allTrangThai1 = true;
//                            hdct.setDonGia(ghct.getDonGia());
//                            if (chiTietKhuyenMai.getKhuyenMai().getDonVi().equals("%")) {
//                                donGiaKhiGiam = ghct.getCtsp().getGiaBan() - (ghct.getCtsp().getGiaBan() * chiTietKhuyenMai.getKhuyenMai().getGiaTri() / 100);
//                                hdct.setDonGiaKhiGiam(donGiaKhiGiam);
//                            }
//                            else {
//                                donGiaKhiGiam = ghct.getCtsp().getGiaBan() - chiTietKhuyenMai.getKhuyenMai().getGiaTri();
//                                hdct.setDonGiaKhiGiam(donGiaKhiGiam);
//                            }
//                        }
//                    }
//                    if (allTrangThai1 == false) {
//                        hdct.setDonGia(ghct.getDonGia());
//                        hdct.setDonGiaKhiGiam(0.0);
//                    }
//                } else {
//                    hdct.setDonGia(ghct.getDonGia());
//                    hdct.setDonGiaKhiGiam(0.0);
//                }
//                hdct.setTrangThai(3);
//                hoaDonChiTietService.save(hdct);
//                ChiTietSanPham ctsp = chiTietSanPhamService.getOne(ghct.getCtsp().getId());
//                ctsp.setSoLuong(ghct.getCtsp().getSoLuong() - ghct.getSoLuong());
//                chiTietSanPhamRepo.save(ctsp);
//                if (ghct.getId() != null) {
//                    gioHangChiTietService.deleteGHCT(ghct.getId());
//                }
//            }
//        }
//        String orderInfo = request.getParameter("vnp_OrderInfo");
//        String paymentTime = request.getParameter("vnp_PayDate");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        Date date = sdf.parse(paymentTime);
//        String transactionId = request.getParameter("vnp_TransactionNo");
//        String totalPrice = request.getParameter("vnp_Amount");
//
//        model.addAttribute("orderId", orderInfo);
//        model.addAttribute("totalPrice", totalPrice);
//        model.addAttribute("paymentTime", date);
//        model.addAttribute("transactionId", transactionId);
//
//        return paymentStatus == 1 ? "/VnPay/success" : "redirect:/bumblebee/cart";
//    }
}
