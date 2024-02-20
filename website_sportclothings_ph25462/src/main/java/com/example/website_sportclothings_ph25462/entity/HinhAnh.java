package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "hinh_anh_san_pham")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "link_anh")
    private String link;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Column(name = "uu_tien")
    private String uuTien;
    @Column(name = "trang_thai")
    private Boolean tt;
    @OneToOne()
    @JoinColumn(name = "san_pham_id")
    private SanPham sanPham;
}
