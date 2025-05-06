package com.example.biblioteca_ex.DTO;

import com.example.biblioteca_ex.entity.Libro;

import java.time.LocalDateTime;
import java.util.List;

public class AutoreDto {

    private Long id;
    private String nome;
    private String nazionalita;
    private LocalDateTime dataNascita;
    private List<Libro> libri;

    public AutoreDto() {
    }

    public AutoreDto(Long id, String nome, String nazionalita, LocalDateTime dataNascita, List<Libro> libri) {
        this.id = id;
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.dataNascita = dataNascita;
        this.libri = libri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public LocalDateTime getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDateTime dataNascita) {
        this.dataNascita = dataNascita;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }
}
