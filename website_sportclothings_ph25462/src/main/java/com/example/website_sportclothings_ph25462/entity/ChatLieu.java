package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;
@Table(name = "chat_lieu")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
<<<<<<< HEAD
    @NotBlank(message = "* không để trống")
    @Length(min = 4,max = 50, message = "* Không dưới 5 kí tự và quá 50 kí tự")
=======
>>>>>>> hoanglc_PH27504
    @Column(name = "ma_chat_lieu")
    private String ma;
    @NotBlank(message = "* không để trống")
    @Length(max = 100, message = "* Không quá 100 kí tự")
    @Column(name = "ten_chat_lieu")
    private String ten;
    @NotNull(message = "* Trạng thái không được để trống")
    @Column(name = "trang_thai")
    private Integer tt;
}
