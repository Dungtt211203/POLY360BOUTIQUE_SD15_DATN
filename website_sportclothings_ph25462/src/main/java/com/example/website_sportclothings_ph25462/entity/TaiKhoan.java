package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "tai_khoan")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma_tai_khoan")
    private String ma;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "so_dien_thoai")
    private Integer sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "ten_tai_khoan")
    private String tenTK;
    @Column(name = "mat_khau")
    private String matKhau;
    @Column(name = "trang_thai")
    private Boolean tt;
    @OneToOne()
    @JoinColumn(name = "vai_tro_id")
    private VaiTro vaiTro;
}
