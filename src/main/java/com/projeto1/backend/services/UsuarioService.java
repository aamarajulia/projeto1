package com.projeto1.backend.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto1.backend.entities.Usuario;
import com.projeto1.backend.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> procuraTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario procuraPorId(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public String adicionaUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "Usuário adicionado com sucesso!";
    }

    public String editarUsuario(Integer id, Usuario usuario){
        Usuario response = usuarioRepository.findById(id).get();

        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setSenha(usuario.getSenha());

        usuarioRepository.save(response);

        return "Usuário editado com sucesso!";
    }

    public void excluirUsuario(Integer id){
        Usuario response = usuarioRepository.findById(id).get();
        usuarioRepository.delete(response);
    }
    
}