package com.example.biblioteca_ex.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "libri")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;

    @Column(name = "genere")
    private String genere;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autore_id")
    private Autore autore;

    public Libro(Long id, String titolo, int annoPubblicazione, String genere) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.genere = genere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return annoPubblicazione == libro.annoPubblicazione && Objects.equals(titolo, libro.titolo) && Objects.equals(genere, libro.genere) && Objects.equals(autore, libro.autore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, annoPubblicazione, genere, autore);
    }
}
