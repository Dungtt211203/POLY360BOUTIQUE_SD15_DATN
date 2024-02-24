package com.example.website_sportclothings_ph25462.service;

<<<<<<< HEAD:website_sportclothings_ph25462/src/main/java/com/example/website_sportclothings_ph25462/service/DiaChiService.java
public interface DiaChiService {
=======
import com.example.website_sportclothings_ph25462.entity.ThuongHieu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface ThuongHieuService {
    List<ThuongHieu> getAll();

    void  add(ThuongHieu thuongHieu);

    void remove(Long id);
>>>>>>> hoanglc_PH27504:website_sportclothings_ph25462/src/main/java/com/example/website_sportclothings_ph25462/service/ThuongHieuService.java
}
