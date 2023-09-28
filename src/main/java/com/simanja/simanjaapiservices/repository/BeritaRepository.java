package com.simanja.simanjaapiservices.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simanja.simanjaapiservices.entity.Berita;

public interface BeritaRepository extends JpaRepository<Berita, String>{
    Berita findByTitle(String title);
    List<Berita> findFirst3ByOrderByPublishDesc();
}
