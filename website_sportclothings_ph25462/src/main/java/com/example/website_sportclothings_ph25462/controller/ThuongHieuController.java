package com.example.website_sportclothings_ph25462.controller;
import com.example.website_sportclothings_ph25462.entity.*;
import com.example.website_sportclothings_ph25462.repository.ThuongHieuRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import com.example.website_sportclothings_ph25462.service.ThuongHieuService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class ThuongHieuController {

    @Autowired
    ThuongHieuRepository thr;
    @Autowired
    ThuongHieuService thuongHieuService;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    HttpSession session;

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

//    public Map<Integer, String> getDsTrangThai() {
//        Map<Integer, String> dsTrangThai = new HashMap<>();
//        dsTrangThai.put(0, " hoạt động");
//        dsTrangThai.put(1, " không Hoạt động");
//        return dsTrangThai;
//    }

    @ModelAttribute(name = "carts")
    public List<GioHangChiTiet> cartItems() {
        List<GioHangChiTiet> gioHangChiTietList = (List<GioHangChiTiet>) session.getAttribute("gioHangCT");
        return gioHangChiTietList;
    }

    @GetMapping("/thuong-hieu/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int th) {
        Pageable pageable = PageRequest.of(th, 5);
        Page<ThuongHieu> page = thuongHieuService.getAll(pageable);
        model.addAttribute("load", thuongHieuService.getAll());
        model.addAttribute("th", new ThuongHieu());
        model.addAttribute("page", page);
        model.addAttribute("view", "../thuong_hieu/chinh-sach.jsp");
        return "/thuong_hieu/index";
    }

    @GetMapping("/thuong-hieu-nike") // chi tiết sản phẩm khi khách hàng nhấn vào sản phẩm
    public String hienThiThuongHieu(Model model) {
        String maSP = "SP1";
        SanPham sanPham = sanPhamService.getOne(maSP);
        List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamService.getCTSPByIdSanPham(sanPham.getId());
        Set<MauSac> mauSacSet = (Set) chiTietSanPhamList.stream().map(ChiTietSanPham::getMauSac).collect(Collectors.toSet());
        Set<KichCo> kichCoSet = (Set) chiTietSanPhamList.stream().map(ChiTietSanPham::getKichCo).collect(Collectors.toSet());
        model.addAttribute("sanPham", sanPham);
        model.addAttribute("listMauSac", mauSacSet);
        model.addAttribute("listKichCo", kichCoSet);
        return "/thuong_hieu/thuong-hieu";
    }

    @GetMapping("/thuong-hieu/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("thuongHieu") ThuongHieu thuongHieu) {
        return ("/thuong_hieu/add");
    }

    @PostMapping("/thuong-hieu/hien-thi-add")
    public String add(Model model, @Valid @ModelAttribute("thuongHieu") ThuongHieu thuongHieu, BindingResult result) {
        Boolean hasError = result.hasErrors();
        ThuongHieu product = thuongHieuService.getOne(thuongHieu.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("mathError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "/thuong_hieu/add.jsp");
            return "/thuong_hieu/add";
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/thuong_hieu/add.jsp");
            return "/thuong_hieu/add";
        }
        thuongHieuService.add(thuongHieu);
        return "redirect:/admin/thuong-hieu/hien-thi";
    }

    @GetMapping("/thuong-hieu/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        thuongHieuService.remove(id);
        return "redirect:/thuong-hieu/hien-thi";
    }
    @GetMapping("/thuong-hieu/view-update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("thuongHieu", thuongHieuService.update(id));
        return "/thuong_hieu/view_update";
    }

    @PostMapping("/thuong-hieu/view-update/{id}")
    public String update(
            @PathVariable Long id, Model model, @Valid @ModelAttribute("thuongHieu") ThuongHieu thuongHieu, BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/thuong_hieu/view_update.jsp");
            return "/thuong_hieu/view_update";
        }
        thuongHieu.setId(id);
        thuongHieuService.add(thuongHieu);
        return "redirect:/admin/thuong-hieu/hien-thi";
    }

}
