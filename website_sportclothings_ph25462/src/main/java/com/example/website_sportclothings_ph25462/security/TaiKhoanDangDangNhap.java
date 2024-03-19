package com.example.website_sportclothings_ph25462.security;


import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.KhachHangRepository;
import com.example.website_sportclothings_ph25462.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaiKhoanDangDangNhap {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public TaiKhoan getCurrentNguoiDung() {
        // Lấy đối tượng Authentication từ SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.printf("Đăng nhập trống");
            return null;
        }

        // Giả sử rằng principal trong đối tượng authentication là một đối tượng User
        // chứa các thông tin cần thiết của khách hàng, bao gồm ID.
        // Đây có thể là một cài đặt tùy chỉnh của UserDetails mà bạn tạo ra.
        Object principal = authentication.getPrincipal();

        // Kiểm tra nếu principal là một instance của UserDetails tùy chỉnh của bạn
        if (principal instanceof UserDetails) {

            // để trả về ID của KhachHang

            String username = ((UserDetails) principal).getUsername();

            // Sử dụng khachHangId để lấy đối tượng KhachHang từ repository
            Optional<TaiKhoan> nguoiDungOptional = taiKhoanRepository.findByUsername(username);
            System.out.printf("//// Thấy " + nguoiDungOptional.get().getTenTK());
            // Trả về đối tượng KhachHang nếu tìm thấy, hoặc null nếu không tìm thấy
            return nguoiDungOptional.orElse(null);
        }

        // Nếu principal trong authentication không phải là instance của UserDetails tùy chỉnh của bạn,
        // đây có thể là dấu hiệu của một cấu hình không đúng hoặc một lỗi.
        // Tùy thuộc vào cách bạn muốn xử lý trường hợp này, bạn có thể trả về null hoặc ném một ngoại lệ.
        return null;
    }

//    public KhachHang getCurrentKhachHang() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return null;
//        }
//        Object principal = authentication.getPrincipal();
//        if (principal instanceof UserDetails) {
//            String username = ((UserDetails) principal).getUsername();// lấy ra tên tk đg đăng nhập
//            System.out.printf("curen nguoiDUng cccccccc: " + username);
//            TaiKhoan taiKhoan = taiKhoanRepository.findTaiKhoanByTenTK(username);
//            KhachHang khachHangOptional = khachHangRepository.getKhachHangByIdTaiKhoan(taiKhoan.getId());
//            return khachHangOptional;
//        }
//
//        return null;
//    }
}
