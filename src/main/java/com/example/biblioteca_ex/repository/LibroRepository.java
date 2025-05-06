package com.example.biblioteca_ex.repository;

import com.example.biblioteca_ex.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {

    //boolean existsByTitoloAndAnnoPubblicazioneAndGenereAndIdAutore(String titolo, int anno, String genere, Long idAutore);
}
