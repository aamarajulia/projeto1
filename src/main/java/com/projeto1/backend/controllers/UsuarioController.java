package com.projeto1.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto1.backend.entities.Usuario;
import com.projeto1.backend.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  
    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){
        return service.salvar(usuario);
    }
    @GetMapping
    public List<Usuario> listar(){
        return service.buscarTodos();
    }
    
}
