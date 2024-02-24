package com.example.website_sportclothings_ph25462.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "chi_tiet_san_pham")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ma_ctsp")
    private String maChiTietSanPham;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "gia_hien_hanh")
    private Float gia;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_sua")
    private Date ngaySua;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "san_pham_id", referencedColumnName = "id")
    private SanPham sanPham;
}
