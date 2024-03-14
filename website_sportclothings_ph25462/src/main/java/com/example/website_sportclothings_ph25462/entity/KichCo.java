package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@Table(name = "kich_co")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KichCo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = " không để trống mã")
    @Length(min = 4,max = 50, message = " Không dưới 5 kí tự và quá 50 kí tự")
    @Column(name = "ma_kich_co")
    private String ma;
    @NotBlank(message = "không để trống tên")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "ten_kich_co")
    private String ten;
    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "trang_thai")
    private Integer tt;
}
