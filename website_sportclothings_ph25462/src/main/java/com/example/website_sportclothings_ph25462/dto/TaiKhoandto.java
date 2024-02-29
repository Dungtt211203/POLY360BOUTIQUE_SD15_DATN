package com.example.website_sportclothings_ph25462.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaiKhoandto implements Serializable {

    private String email;
    private String tenTK;
    private String matKhau;
    private String checkmatKhau;

    public TaiKhoandto(String Email, String TenTK, String MatKhau) {
        email = Email;
        tenTK = TenTK;
        matKhau = MatKhau;

    }


}
