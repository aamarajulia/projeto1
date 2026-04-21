package com.projeto1.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.projeto1.backend.entities.Usuario;
import com.projeto1.backend.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar(){
        return service.procuraTodos();
    }

    @GetMapping(value ="/{id}")
    public Usuario procuraPorId(@PathVariable Integer id){
        Usuario response = service.procuraPorId(id);
        return response;
    }

    @PostMapping
    public String salvar(@RequestBody Usuario usuario){
        String response = service.adicionaUsuario(usuario);
        return response;
    }
    
    @PutMapping(value="/{id}")
    public String editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        String response = service.editarUsuario(id, usuario);
        return response;
    }

    @DeleteMapping(value="/{id}")
    public void excluirUsuario(@PathVariable Integer id){
        service.excluirUsuario(id);
    }

    
    
}
