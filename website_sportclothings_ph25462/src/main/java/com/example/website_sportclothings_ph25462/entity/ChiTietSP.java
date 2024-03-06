package com.example.website_sportclothings_ph25462.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "chi_tiet_san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = " không để trống mã")
    @Length(min = 3, max = 50, message = " Không dưới 3 kí tự và quá 50 kí tự")
    @Column(name = "ma_ctsp")
    private String ma;

    @NotNull(message = "Số lượng không được để trống")
    @Column(name = "so_luong")
    private Integer soLuong;

//    @Column(name = "gia_hien_hanh")
//    private Long giaHienHanh;
    @Column(name = "trang_thai")
    private Integer trangThai;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "san_pham_id", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kich_co_id", referencedColumnName = "id")
    private KichCo kichCo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mau_sac_id", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_lieu_id", referencedColumnName = "id")
    private ChatLieu chatLieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "thuong_hieu_id", referencedColumnName = "id")
    private ThuongHieu thuongHieu;

}
