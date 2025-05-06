package com.example.biblioteca_ex.controller;

import com.example.biblioteca_ex.repository.AutoreRespository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autore/api")
public class AutoreController {

    private AutoreRespository autoreRespository;
}
