package com.example.biblioteca_ex.interf;

import com.example.biblioteca_ex.DTO.AutoreDto;

public interface AutoreInterface {

    AutoreDto createAutore(AutoreDto autoreDto);
    AutoreDto updateAutoreById(Long id, AutoreDto autoreDto);
}
