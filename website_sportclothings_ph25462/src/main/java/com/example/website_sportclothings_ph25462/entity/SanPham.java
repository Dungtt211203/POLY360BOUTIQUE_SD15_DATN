package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "san_pham")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_san_pham")
    private String ma;
    @Column(name = "ten_san_pham")
    private String ten;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Column(name = "nguoi_tao")
    private String nguoiTao;
    @Column(name = "trang_thai")
    private Integer tt;
}
