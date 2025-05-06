package com.example.biblioteca_ex.DTO;

import java.util.Objects;

public class LibroDto {

    private Long id;
    private String titolo;
    private int annoPubblicazione;
    private String genere;
    private Long idAutore;

    public LibroDto(Long id, String titolo, int annoPubblicazione, String genere, Long idAutore) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.genere = genere;
        this.idAutore = idAutore;
    }

    public LibroDto() {
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

    public Long getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Long idAutore) {
        this.idAutore = idAutore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibroDto libroDto = (LibroDto) o;
        return annoPubblicazione == libroDto.annoPubblicazione && Objects.equals(titolo, libroDto.titolo) && Objects.equals(genere, libroDto.genere) && Objects.equals(idAutore, libroDto.idAutore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, annoPubblicazione, genere, idAutore);
    }
}
