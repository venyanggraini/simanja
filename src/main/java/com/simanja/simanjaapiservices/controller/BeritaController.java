package com.simanja.simanjaapiservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.simanja.simanjaapiservices.entity.Berita;
import com.simanja.simanjaapiservices.service.BeritaService;

@RestController
@RequestMapping("/api/berita")
public class BeritaController {
    
    @Autowired
    private BeritaService beritaService;

    @GetMapping("/listBerita")
    public List<Berita> showAllBerita() {
        return beritaService.getAllBerita();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addBerita")
    public void addBerita(@RequestBody Berita berita) {
        beritaService.addBerita(berita);
    }

    @GetMapping("/topThreeBerita")
    public List<Berita> topThreeBerita() {
        return beritaService.getTopThreBerita();
    }

    @GetMapping("/detailBerita/{id}")
    public Berita showBerita(@PathVariable Long id) {
        return beritaService.getBerita(id);
    }
}
