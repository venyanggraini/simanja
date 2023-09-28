package com.simanja.simanjaapiservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.simanja.simanjaapiservices.entity.Berita;
import com.simanja.simanjaapiservices.service.BeritaService;

@SpringBootApplication
public class SimanjaApiServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimanjaApiServicesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BeritaService beritaService) {
		return (args) -> {
			// save few berita
			Berita berita1 = new Berita();
			berita1.setTitle("Testing Add Berita 1");
			berita1.setContent("Apa aja boleh tentang berita 1");

			Berita berita2 = new Berita();
			berita2.setTitle("Testing Add Berita 2");
			berita2.setContent("Apa aja boleh tentang berita 2");

			Berita berita3 = new Berita();
			berita3.setTitle("Testing Add Berita 3");
			berita3.setContent("Apa aja boleh tentang berita 3");
			
			Berita berita4 = new Berita();
			berita4.setTitle("Testing Add Berita 4");
			berita4.setContent("Apa aja boleh tentang berita 4");
			
			Berita berita5 = new Berita();
			berita5.setTitle("Testing Add Berita 5");
			berita5.setContent("Apa aja boleh tentang berita 5");

			beritaService.addBerita(berita1);
			beritaService.addBerita(berita2);
			beritaService.addBerita(berita3);
			beritaService.addBerita(berita4);
			beritaService.addBerita(berita5);

			// fetch all person
			System.out.println("-----List of Berita------");
			for (Berita berita : beritaService.getAllBerita()) {
				System.out.println("Berita Detail:" + berita);
			}
		};
	}
}
