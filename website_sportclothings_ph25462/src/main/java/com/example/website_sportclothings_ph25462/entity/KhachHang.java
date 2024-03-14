package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Table(name = "khach_hang")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = " không để trống mã")
    @Length(min = 5,max = 50, message = " Không dưới 5 kí tự và quá 50 kí tự")
    @Column(name = "ma_khach_hang")
    private String ma;
    @NotBlank(message = "không để trống họ")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "ho")
    private String ho;
    @NotBlank(message = "không để trống tên đệm")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "ten_dem")
    private String tenDem;
    @NotBlank(message = "không để trống tên")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "ten")
    private String ten;
    @NotNull(message = "Gioi tinh không được để trống")
    @Column(name = "gioi_tinh")
    private Integer gioiTinh;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "không để trống ngày sinh")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @NotBlank(message = "không để trống địa chỉ")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "dia_chi")
    private String diaChi;
    @Pattern(regexp="^0\\d{9}$", message="Số điện thoại không hợp lệ")
    @Column(name = "so_dien_thoai")
    private String sdt;
    @NotBlank(message = "không để trống email")
    @Email(message = "Email không hợp lệ")
    @Column(name = "email")
    private String email;
    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "trang_thai")
    private Integer tt;
    @OneToOne()
    @JoinColumn(name = "tai_khoan_id")
    private TaiKhoan taiKhoanKH;
}
