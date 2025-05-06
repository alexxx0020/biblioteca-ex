package com.example.biblioteca_ex.serviceImpl;

import com.example.biblioteca_ex.DTO.LibroDto;
import com.example.biblioteca_ex.entity.Libro;
import com.example.biblioteca_ex.exception.ResourceNotFountException;
import com.example.biblioteca_ex.interf.LibroInterface;
import com.example.biblioteca_ex.repository.LibroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LibroService implements LibroInterface {

    private ModelMapper modelMapper;
    private LibroRepository libroRepository;

    public LibroService(ModelMapper modelMapper, LibroRepository libroRepository) {
        this.modelMapper = modelMapper;
        this.libroRepository = libroRepository;
    }

    @Override
    public LibroDto createLibro(LibroDto libroDto) {
        if (libroDto != null && libroRepository.findAll().stream()
                .map(l -> modelMapper.map(l, LibroDto.class))
                .noneMatch(l -> l.equals(libroDto))){

            Libro l = modelMapper.map(libroDto, Libro.class);

            LibroDto saved = modelMapper.map(libroRepository.save(l), LibroDto.class);

            return saved;
        } else {
            throw new ResourceNotFountException("Nessun elemento valido passato");
        }
    }

    @Override
    public LibroDto getLibroById(Long id) {
        Libro l = libroRepository.findById(id).orElseThrow(
                () -> new ResourceNotFountException("Nessun elemento valido con id: " + id)
        );

        return modelMapper.map(l,LibroDto.class);
    }

    @Override
    public LibroDto updateLibroById(Long id, LibroDto libroDto) {
        return null;
    }

    @Override
    public LibroDto deleteById(Long id) {
        Libro l = libroRepository.findById(id).orElseThrow(
                () -> new ResourceNotFountException("Nessun elemento valido con id: " + id)
        );

        LibroDto libroDto = modelMapper.map(l, LibroDto.class);

        libroRepository.delete(l);

        return libroDto;
    }
}
