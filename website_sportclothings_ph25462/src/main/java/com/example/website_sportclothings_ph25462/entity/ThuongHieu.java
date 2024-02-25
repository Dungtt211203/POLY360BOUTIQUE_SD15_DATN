package com.example.website_sportclothings_ph25462.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;



@Table(name = "thuong_hieu")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThuongHieu {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_thuong_hieu")
    private String ma;
    @Column(name = "ten_thuong_hieu")
    private String ten;
    @Column(name = "trang_thai")
    private Integer tt;
}
