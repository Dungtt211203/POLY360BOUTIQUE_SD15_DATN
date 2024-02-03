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

@Table(name = "mau_sac")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ten_mau_sac")
    private String ten;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Column(name = "trang_thai")
    private Integer tt;
}
