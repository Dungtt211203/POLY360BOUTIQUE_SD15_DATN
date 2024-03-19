package com.example.website_sportclothings_ph25462.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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
    @NotBlank(message = " không để trống mã")
    @Length(min = 5,max = 50, message = " Không dưới 5 kí tự và quá 50 kí tự")
    @Column(name = "ma_thuong_hieu")
    private String ma;
    @NotBlank(message = "không để trống tên")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "ten_thuong_hieu")
    private String ten;
    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "trang_thai")
    private Integer tt;
}
