package com.example.biblioteca_ex.interf;

import com.example.biblioteca_ex.DTO.LibroDto;

public interface LibroInterface {

    LibroDto createLibro(LibroDto libroDto);

    LibroDto getLibroById(Long id);

    LibroDto updateLibroById(Long id,LibroDto libroDto);

    LibroDto deleteById(Long id);
}
