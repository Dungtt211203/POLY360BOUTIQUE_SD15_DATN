package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


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

    @NotBlank(message = " không để trống mã")
    @Length(min = 5, max = 50, message = " Không dưới 5 kí tự và quá 50 kí tự")
    @Column(name = "ma_san_pham")
    private String ma;

    @NotBlank(message = "không để trống tên")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "ten_san_pham")
    private String ten;

    @NotBlank(message = "không để trống mô tả")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia")
    @DecimalMin(value = "79999", inclusive = false, message = " Giá bán không hợp lệ, nhập giá nhỏ nhất là 80000")
    @DecimalMax(value = "9999999999.99", inclusive = false, message = " Giá bán không hợp lệ")
    @NotNull(message = "* không để trống giá bán !")
    private Double gia;

    //    @Temporal(TemporalType.DATE)
//    @NotNull(message = "không để trống ngày tạo")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Column(name = "ngay_tao")
//    private Date ngayTao;
//    @Temporal(TemporalType.DATE)
//    @NotNull(message = "không để trống ngày sửa")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Column(name = "ngay_sua")
//    private Date ngaySua;
//    @NotBlank(message = "không để trống người tạo")

    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "nguoi_tao")
    private String nguoiTao;

    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "trang_thai")
    private Integer tt;
}
