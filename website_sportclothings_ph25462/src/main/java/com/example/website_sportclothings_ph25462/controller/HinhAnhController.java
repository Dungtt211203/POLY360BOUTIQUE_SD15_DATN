package com.example.website_sportclothings_ph25462.controller;

;
import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import com.example.website_sportclothings_ph25462.entity.HinhAnhSP;
import com.example.website_sportclothings_ph25462.service.HinhAnhSPService;
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

@Controller
@RequestMapping("/admin")
public class HinhAnhController {
    @Autowired
    HinhAnhSPService hinhAnhSPService;

    @GetMapping("/hinh-anh/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int ha) {
        Pageable pageable = PageRequest.of(ha, 5);
        Page<HinhAnhSP> page = hinhAnhSPService.getAll(pageable);
        model.addAttribute("load", hinhAnhSPService.getAll());
        model.addAttribute("ha", new HinhAnhSP());
        model.addAttribute("page", page);
//        model.addAttribute("search", searchForm);
        return "/hinh_anh/index";
    }

    @GetMapping("/hinh-anh/hien-thi-add")
    public String hienThiAdd(@ModelAttribute("hinhAnh") HinhAnhSP hinhAnhSP) {
        return ("/hinh_anh/add");
    }

    @GetMapping("/hinh-anh/view-update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("hinhAnh", hinhAnhSPService.update(id));
        return "/hinh_anh/view_update";
    }

    @PostMapping("/hinh_anh/view-update/{id}")
    public String update(
            @PathVariable Long id, Model model, @Valid @ModelAttribute("hinhAnh") HinhAnhSP hinhAnhSP, BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/hinh_anh/view_update.jsp");
            return "/hinh_anh/view_update";
        }
        hinhAnhSP.setId(id);
        hinhAnhSPService.add(hinhAnhSP);
        return "redirect:/admin/hinh-anh/hien-thi";
    }

//    @PostMapping("/add/chat-lieu")
//    public ResponseEntity<?> add(@RequestBody @Valid ChatLieu chatLieu) {
//        return ResponseEntity.ok(clr.save(chatLieu));
//    }

    @PostMapping("/hinh-anh/hien-thi-add")
    public String add(Model model, @Valid @ModelAttribute("hinhAnh") HinhAnhSP hinhAnhSP, BindingResult result) {
        Boolean hasError = result.hasErrors();
//        HinhAnhSP product = HinhAnhSPService.getOne(chatLieu.getMa());
//        if (product != null) {
//            hasError = true;
//            model.addAttribute("maclError", "Vui lòng không nhập trùng mã");
//            model.addAttribute("view", "/chat_lieu/add.jsp");
//            return "/chat_lieu/add";
//        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "/hinh_anh/add.jsp");
            return "/hinh_anh/add";
        }
        hinhAnhSPService.add(hinhAnhSP);
        return "redirect:/admin/hinh-anh/hien-thi";
    }


    @GetMapping("/hinh-anh/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        hinhAnhSPService.remove(id);
        return "redirect:/admin/hinh-anh/hien-thi";
    }

}
