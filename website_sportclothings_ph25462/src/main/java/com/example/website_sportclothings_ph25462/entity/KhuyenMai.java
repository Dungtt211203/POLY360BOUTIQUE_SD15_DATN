package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "khuyen_mai")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_khuyen_mai")
    private String maKhuyenMai;
    @Column(name = "ten_khuyen_mai")
    private String tenKhuyenMai;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_ket_thuc")
    private LocalDateTime ngayKetThuc;
    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat;
    @Column(name = "trang_thai")
    private Long trangThai;

    @OneToMany(mappedBy = "khuyenMai", fetch = FetchType.EAGER)
    private List<ChiTietKhuyenMai> chiTietKhuyenMaiList;

}
