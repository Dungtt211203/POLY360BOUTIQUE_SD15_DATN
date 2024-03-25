package com.example.website_sportclothings_ph25462.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @NotBlank(message = "Email không được để trống")
    private String toEmail;
    @NotBlank(message = "Tiêu đề không được để trống")
    private String subject;
    @NotBlank(message = "Body không được để trống")
    private String body;
}
