package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "vai_tro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VaiTro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma_vai_tro")
    private String maVT;
    @Column(name = "ten_vai_tro")
    private String tenVT;
}
