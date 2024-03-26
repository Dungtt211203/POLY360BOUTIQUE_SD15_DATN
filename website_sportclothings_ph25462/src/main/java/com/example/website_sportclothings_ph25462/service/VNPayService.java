package com.example.website_sportclothings_ph25462.service;

import jakarta.servlet.http.HttpServletRequest;

public interface VNPayService {
    public String createOrder(Long total, String orderInfor, String urlReturn);

    public int orderReturn(HttpServletRequest request);
}
