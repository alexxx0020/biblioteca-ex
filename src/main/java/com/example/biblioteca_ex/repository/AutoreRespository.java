package com.example.biblioteca_ex.repository;

import com.example.biblioteca_ex.entity.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRespository extends JpaRepository<Autore,Long> {
}
