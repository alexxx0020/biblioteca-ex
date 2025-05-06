package com.example.biblioteca_ex.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "autori")
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nazionalità")
    private String nazionalita;

    @Column(name = "data_nascita")
    private LocalDateTime dataNascita;

    @OneToMany(mappedBy = "autore")
    private List<Libro> libri;

    public Autore(Long id, String nome, String nazionalita, LocalDateTime dataNascita, List<Libro> libri) {
        this.id = id;
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.dataNascita = dataNascita;
        this.libri = libri;
    }

    public Autore() {
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
