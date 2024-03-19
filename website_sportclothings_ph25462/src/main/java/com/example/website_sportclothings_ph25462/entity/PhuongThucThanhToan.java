package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "phuong_thuc_thanh_toan")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhuongThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "ma_phuong_thuc")
    private String maPhuongThuc;
    @Column(name = "ten_phuong_thuc")
    private String tenPhuongThuc;
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "trang_thai")
    private Integer trangThai;
}
