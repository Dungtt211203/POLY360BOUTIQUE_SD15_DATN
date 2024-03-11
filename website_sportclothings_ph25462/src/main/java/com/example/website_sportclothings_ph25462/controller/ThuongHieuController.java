package com.example.website_sportclothings_ph25462.controller;
import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.entity.KichCo;
import com.example.website_sportclothings_ph25462.entity.MauSac;
import com.example.website_sportclothings_ph25462.entity.SanPham;
import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import com.example.website_sportclothings_ph25462.repository.ThuongHieuRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietSanPhamService;
import com.example.website_sportclothings_ph25462.service.SanPhamService;
import com.example.website_sportclothings_ph25462.service.ThuongHieuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/poly360boutique")
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
    public String hienThi(Model model) {
        model.addAttribute("load", thuongHieuService.getAll());
        model.addAttribute("th", new ThuongHieu());
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
    public String hienThiAdd(@ModelAttribute("thuongHieu") SanPham sanPham) {
        return ("/thuong_hieu/add");
    }

    @PostMapping("/thuong-hieu/hien-thi-add")
    public String add(@ModelAttribute("thuongHieu") ThuongHieu thuongHieu) {
        thuongHieuService.add(thuongHieu);
        return "redirect:/thuong_hieu/hien-thi";
    }

    @GetMapping("/thuong-hieu/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        thuongHieuService.remove(id);
        return "redirect:/thuong-hieu/hien-thi";
    }


}
