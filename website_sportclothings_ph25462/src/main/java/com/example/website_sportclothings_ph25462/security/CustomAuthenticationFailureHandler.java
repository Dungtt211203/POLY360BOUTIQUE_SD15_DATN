package com.example.website_sportclothings_ph25462.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String errUsername = "", errPassword = "";
        if (username.isBlank()) {
            errUsername = "Khong duoc trong";
        }
        if (password.isBlank()) {
            errPassword = "Khong duoc trong";
        }

        if (errUsername.isBlank() && errPassword.isBlank()) {
            request.setAttribute("errorMessage", "Tên tài khoản hoặc mật khẩu không chính xác");
            response.sendRedirect("/login?error");
        } else {
            request.setAttribute("errorUsername", errUsername);
            request.setAttribute("errorPassword", errPassword);
            request.setAttribute("errorMessage", "Tên tài khoản hoặc mật khẩu không chính xác");
            request.getRequestDispatcher("WEB-INF/view/login/dangnhap.jsp").forward(request, response);
        }
    }

}
