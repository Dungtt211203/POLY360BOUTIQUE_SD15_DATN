package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String tinh;
    @Column(name = "dia_chi_cu_the")
    private String diaChi;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "sdt")
    private String sdt;


    @Column(name = "trang_thai")
    private Integer trangThai;
    @OneToOne()
    @JoinColumn(name = "tai_khoan_id")
    private TaiKhoan taiKhoanKH;


    @Column(name = "district_id")
    private Integer districtID; // mã huyện

    @Column(name = "Ward_code")
    private Integer wardCode; // mã phường xã


}
