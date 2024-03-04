package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.VaiTro;
import com.example.website_sportclothings_ph25462.repository.VaiTroRepository;
import com.example.website_sportclothings_ph25462.service.VaiTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VaiTroServiceImpl implements VaiTroService {

    @Autowired
    private VaiTroRepository vaiTroRepository;

    @Override
    public List<VaiTro> getAll() {
        return vaiTroRepository.findAll();
    }

    @Override
    public void add(VaiTro vaiTro) {
        vaiTroRepository.save(vaiTro);
    }
}
