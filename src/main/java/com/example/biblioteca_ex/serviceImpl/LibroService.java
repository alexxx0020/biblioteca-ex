package com.example.biblioteca_ex.serviceImpl;

import com.example.biblioteca_ex.DTO.LibroDto;
import com.example.biblioteca_ex.entity.Libro;
import com.example.biblioteca_ex.exception.ResourceNotFountException;
import com.example.biblioteca_ex.interf.LibroInterface;
import com.example.biblioteca_ex.repository.AutoreRespository;
import com.example.biblioteca_ex.repository.LibroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService implements LibroInterface {

    private ModelMapper modelMapper;
    private LibroRepository libroRepository;
    private AutoreRespository autoreRespository;

    public LibroService(ModelMapper modelMapper, LibroRepository libroRepository, AutoreRespository autoreRespository) {
        this.modelMapper = modelMapper;
        this.libroRepository = libroRepository;
        this.autoreRespository = autoreRespository;
    }

    @Override
    public LibroDto createLibro(LibroDto libroDto) {
        if (autoreRespository.findAll().isEmpty()){
            if (libroDto != null && libroRepository.findAll().stream()
                    .map(l -> modelMapper.map(l, LibroDto.class))
                    .noneMatch(l -> l.equals(libroDto))){

                Libro l = modelMapper.map(libroDto, Libro.class);

                LibroDto saved = modelMapper.map(libroRepository.save(l), LibroDto.class);

                return saved;
            } else {
                throw new ResourceNotFountException("Nessun elemento valido passato");
            }
        } else {
            throw new ResourceNotFountException("Nessun autore presente da assegnare ad autore libro");
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
        Libro l = libroRepository.findById(id).orElseThrow(
                () -> new ResourceNotFountException("Nessun elemento presente con id: " + id)
        );

        l.setAutore(autoreRespository.findById(id).orElseThrow(
                () -> new ResourceNotFountException("Non ci sono autori")
        ));
        l.setGenere(libroDto.getGenere());
        l.setTitolo(libroDto.getTitolo());
        l.setAnnoPubblicazione(libroDto.getAnnoPubblicazione());

        Libro saved = libroRepository.save(l);

        return modelMapper.map(saved,LibroDto.class);
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

    @Override
    public List<LibroDto> getAll() {

        return libroRepository.findAll().stream()
                .map(l -> modelMapper.map(l, LibroDto.class))
                .toList();

//        List<Libro> lirbi = libroRepository.findAll();
//        List<LibroDto> list = new ArrayList<>();
//
//        for (Libro l : libri){
////            list.add(modelMapper.map(l, LibroDto.class));
//        }
//
//        return list;
    }
}
