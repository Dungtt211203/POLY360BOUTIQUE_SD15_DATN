package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.entity.NhanVien;
import com.example.website_sportclothings_ph25462.repository.NhanVienRepository;
import com.example.website_sportclothings_ph25462.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NhanVienController {
    @Autowired
    NhanVienRepository nvr;
    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("/nhan-vien/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("load", nhanVienService.getAll());
        model.addAttribute("nv", new NhanVien());
        model.addAttribute("view", "../nhan_vien/index.jsp");
        return "/nhan_vien/index";
    }

    @GetMapping("/nhan-vien/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        return ("/nhan_vien/add");
    }

    @GetMapping("/nhan-vien/view-update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("nhanVien", nhanVienService.update(id));
        return "/nhan_vien/view_update";
    }

    @PostMapping("/nhan-vien/view-update/{id}")
    public String update(
            @PathVariable Long id, Model model,@Valid @ModelAttribute("nhanVien") NhanVien nhanVien,BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
            if (hasError) {
                // Báo lỗi
                model.addAttribute("view", "/nhan_vien/view_update.jsp");
                return "/nhan_vien/view_update";
            }
        nhanVien.setId(id);
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/nhan-vien/hien-thi-add")
    public String add(Model model, @Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result) {
        Boolean hasError = result.hasErrors();
        NhanVien product = nhanVienService.getOne(nhanVien.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("manvError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "/nhan_vien/add.jsp");
            return "/nhan_vien/add";
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/nhan_vien/add.jsp");
            return "/nhan_vien/add";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/nhan-vien/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        nhanVienService.remove(id);
        return "redirect:/nhan-vien/hien-thi";
    }

//    @GetMapping("/search")
//    public String search(Model model, @ModelAttribute("key") String key, @RequestParam(defaultValue = "0", name = "page") Integer page) {
//        Pageable pageable = PageRequest.of(page, 5);
//        Page<KhachHang> list = khachHangService.search(key, pageable);
//        model.addAttribute("list", list);
//        return "redirect:/khach-hang/hien-thi";
//    }
}
