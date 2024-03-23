package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Table(name = "hinh_anh_san_pham")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HinhAnhSP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = " không để trống url")
    @Column(name = "url")
    private String url;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "không để trống ngày tạo")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "không để trống ngày sửa")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @NotNull(message = " không để trống trạng thái")
    @Column(name = "trang_thai")
    private Integer trangThai;
    @NotBlank(message = " không để trống ưu tiên")
    @Column(name = "uu_tien")
    private String uuTien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "san_pham_id", referencedColumnName = "id")
    private SanPham sanPham;

}
