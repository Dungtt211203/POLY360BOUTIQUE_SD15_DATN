package com.example.website_sportclothings_ph25462.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
>>>>>>> hoanglc_PH27504
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
<<<<<<< HEAD
=======

>>>>>>> hoanglc_PH27504
@Table(name = "thuong_hieu")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThuongHieu {
<<<<<<< HEAD
=======

>>>>>>> hoanglc_PH27504
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_thuong_hieu")
<<<<<<< HEAD
    private String maTH;
    @Column(name = "ten_thuong_hieu")
    private String tenTH;
=======
    private String ma;
    @Column(name = "ten_thuong_hieu")
    private String ten;
>>>>>>> hoanglc_PH27504
    @Column(name = "trang_thai")
    private Integer tt;
}
