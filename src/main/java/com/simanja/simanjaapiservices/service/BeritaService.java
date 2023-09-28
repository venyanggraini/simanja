package com.simanja.simanjaapiservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simanja.simanjaapiservices.entity.Berita;
import com.simanja.simanjaapiservices.repository.BeritaRepository;

@Service
public class BeritaService {
    @Autowired
    private BeritaRepository repository;

    public List<Berita> getAllBerita() {
        List<Berita> listBerita = new ArrayList<>();
        repository.findAll().forEach(listBerita::add);    
        return listBerita;    
    }

    public void addBerita(Berita berita) {
        repository.save(berita);
    }

    public List<Berita> getTopThreBerita() {
        return repository.findFirst3ByOrderByPublishDesc();
    }

    public Berita getBerita(Long id) {
        return repository.findById(id).get();
    }
}
