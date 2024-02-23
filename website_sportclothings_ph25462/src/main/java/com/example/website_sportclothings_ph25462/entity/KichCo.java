package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Table(name = "kich_co")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KichCo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_kich_co")
    private String ma;
    @Column(name = "ten_kich_co")
    private String ten;
    @Column(name = "trang_thai")
    private Integer tt;
}
