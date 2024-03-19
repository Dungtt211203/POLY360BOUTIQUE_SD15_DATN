package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "hoa_don")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_hoa_don")
    private String maHoaDon;
    @Column(name = "ngay_thanh_toan")
    private LocalDateTime ngayThanhToan;
    @Column(name = "loai_hoa_don")
    private String loaiHoaDon;
    @Column(name = "phi_giao_hang")
    private Long phiGiaoHang;
    @Column(name = "tong_tien")
    private Long tongTien;
    @Column(name = "gia_phai_tra")
    private Long giaPhaTra;
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "nguoi_nhan")
    private String nguoiNhan;
    @Column(name = "sdt_nguoi_nhan")
    private Integer soDienThoai;
    @Column(name = "dia_chi_nguoi_nhan")
    private String diaChiNguoiNhan;
    @Column(name = "phuong_xa")
    private String phuongXa;
    @Column(name = "quan_huyen")
    private String quanHuyen;
    @Column(name = "thanh_pho")
    private String thanhPho;
    @Column(name = "ngay_nhan")
    private LocalDateTime ngayNhan;
    @Column(name = "ngay_mong_muon")
    private LocalDateTime ngayMongMuon;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;
    @Column(name = "trang_thai")
    private Integer trangThai;// 1 thanh cong, 2 tro xac nhan, 3 da xac nhan, 4 dang giao , 5 giao thanh cong, 0 huy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nhan_vien", referencedColumnName = "id")
    private NhanVien nhanVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_khach_hang", referencedColumnName = "id")
    private KhachHang khachHang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vouver_id", referencedColumnName = "id")
    private Voucher voucher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tai_khoan_id", referencedColumnName = "id")
    private TaiKhoan taiKhoan;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phuong_thuc_thanh_toan_id", referencedColumnName = "id")
    private PhuongThucThanhToan phuongThucThanhToan;
}

