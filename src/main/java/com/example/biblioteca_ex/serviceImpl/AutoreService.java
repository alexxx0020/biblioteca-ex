package com.example.biblioteca_ex.serviceImpl;

import com.example.biblioteca_ex.DTO.AutoreDto;
import com.example.biblioteca_ex.interf.AutoreInterface;
import com.example.biblioteca_ex.repository.AutoreRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AutoreService implements AutoreInterface {

    private ModelMapper modelMapper;
    private AutoreRespository autoreRespository;

    @Override
    public AutoreDto createAutore(AutoreDto autoreDto) {
        return null;
    }

    @Override
    public AutoreDto updateAutoreById(Long id, AutoreDto autoreDto) {
        return null;
    }
}
