package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "khach_hang")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_khach_hang")
    private String ma;
    @Column(name = "ho")
    private String ho;
    @Column(name = "ten_dem")
    private String tenDem;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gioi_tinh")
    private Integer gioiTinh;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "so_dien_thoai")
    private Integer sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "trang_thai")
    private Integer tt;
    @OneToOne()
    @JoinColumn(name = "tai_khoan_id")
    private TaiKhoan taiKhoanKH;
}
