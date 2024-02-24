package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "dia_chi")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_dia_chi")
    private String ma;
    @Column(name = "phuong_xa")
    private String phuongXa;
    @Column(name = "quan_huyen")
    private String quanHuyen;
    @Column(name = "thanh_pho")
    private String thanhPho;
    @Column(name = "tinh")
    private Boolean tinh;
    @Column(name = "dia_chi_cu_the")
    private String diaChi;
    @Column(name = "trang_thai")
    private Boolean tt;
    @OneToOne()
    @JoinColumn(name = "id_tai_khoan")
    private TaiKhoan taiKhoanKH;
}
