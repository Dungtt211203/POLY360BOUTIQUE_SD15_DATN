package com.example.website_sportclothings_ph25462.security;

public class SecurityConstants {
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String[] ENDPOINTS_WHITELIST = {
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/login",
            "/register/**",
            "/products/**",
            "/add-to-cart/**",
            "/product-details",
            "/shopping-cart",
            "/checkout",
            "/about-us",
            "/faq",
            "/contact",
            "/static/**", // cau hinh tai nguyen tinh nhu css, js, image,...
            // luu y: duong dan tai nguyen tinh phu thuoc vao uri cua request: /customer -> /static/.. neu /customer/save -> customer/static/.. khi su dung duong dan tuong doi @{/static}, tranh loi nay thi nen dung duong dan tuyet doi @{~/static}
            "/api/**",

            "/admin/**",
            "/pos/**",
            "/user/**",

    };

    // Form Login Config
    public static final String LOGIN_URL = "/login";
    public static final String LOGOUT_URL = "/logout";
    public static final String LOGIN_FAIL_URL = LOGIN_URL + "?error";
    public static final String DEFAULT_SUCCESS_URL = "/poly360boutique/home";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
}
