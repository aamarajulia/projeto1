package com.projeto1.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import com.projeto1.backend.entities.Usuario;
import com.projeto1.backend.repositories.UsuarioRepository;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }
    @GetMapping
    public List<Usuario> listar(){
        return repository.findAll();
    }
    
}
