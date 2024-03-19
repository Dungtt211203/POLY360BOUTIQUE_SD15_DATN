package com.example.website_sportclothings_ph25462.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }

    @Bean(name = "passwordEncoder")
    public static PasswordEncoder passwordEncoder() { // de static de tao duy nhat 1 passwordEncoder
        return new BCryptPasswordEncoder();
    }

    @Bean()
    public SimpleUrlAuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean(name = "securityFilterChain")
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> {
            csrf.disable();
        })

                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/staff/**").hasAnyRole("STAFF", "ADMIN")
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .requestMatchers("/user/**").authenticated() // Chặn truy cập tất cả các trang có thông tin về người dùng
                            .requestMatchers(HttpMethod.GET, "/cart-save").permitAll()
                            .requestMatchers(HttpMethod.POST, "/add-to-cart/**").permitAll()
                            .requestMatchers("/checkout").authenticated()
                            .anyRequest().permitAll();

                })


                .formLogin(form -> {
                    form
                            .loginPage("/login") // post
                            .loginProcessingUrl("/login")
                            .usernameParameter(SecurityConstants.USERNAME)
                            .passwordParameter(SecurityConstants.PASSWORD)
                            .successHandler(simpleUrlAuthenticationSuccessHandler())
                            .permitAll();
                });


        return http.build();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


}
