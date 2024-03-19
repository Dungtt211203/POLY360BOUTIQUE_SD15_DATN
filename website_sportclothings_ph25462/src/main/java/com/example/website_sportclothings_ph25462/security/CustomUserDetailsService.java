package com.example.website_sportclothings_ph25462.security;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not exists"));

//        Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) mapRolesToAuthorities(user.get);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();// Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

            authorities.add(new SimpleGrantedAuthority("ROLE_" + taiKhoan.getVaiTro().getTenVT().toUpperCase()));

        // dung ham constructor nay thi mac dinh cac gia tri accountNonExpired, accountNonLocked, credentialsNonExpired, enabled = true;
        User user = new User(
                username,
                taiKhoan.getMatKhau(),
                authorities
        );
        return user;

        // thuong se viet rieng 1 custom UserDetails de tra ve thong tin tu UserEntity
//        return new MyUserPrincipal(user);
    }


}
