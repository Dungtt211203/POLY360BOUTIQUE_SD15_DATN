package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {


    @Query("select tk from TaiKhoan tk where tk.tenTK LIKE :tenTK and tk.matKhau LIKE :matKhau ")
    TaiKhoan findTaiKhoanByTenTKAndMatKhau(String tenTK, String matKhau);

    @Query("select tk from TaiKhoan tk where tk.tenTK LIKE :tenTK")
    TaiKhoan findTaiKhoanByTenTK(String tenTK);

    @Query("select tk from TaiKhoan tk where tk.tenTK LIKE :username")
    Optional<TaiKhoan> findByUsername(String username);


}
