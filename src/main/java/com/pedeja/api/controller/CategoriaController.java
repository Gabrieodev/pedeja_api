package com.pedeja.api.controller;

import com.pedeja.api.model.Categoria;
import com.pedeja.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }
}
