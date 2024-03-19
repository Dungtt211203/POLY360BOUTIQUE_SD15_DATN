package com.example.website_sportclothings_ph25462.security;

import com.example.website_sportclothings_ph25462.service.GioHangChiTietService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {


        List<String> roleList = authentication.getAuthorities().stream().map(data -> data.getAuthority()).collect(Collectors.toList());

        if (roleList.get(0).equalsIgnoreCase("ROLE_USER")) {
            gioHangChiTietService.loginAddToCart();

            response.sendRedirect("/poly360boutique/home");
        } else if (roleList.get(0).equalsIgnoreCase("ROLE_ADMIN")) {

            response.sendRedirect("/poly360boutique/admin");
        } else {
            response.sendRedirect("/logout");

        }

    }

}
