package com.scaef.service;

import java.util.Optional;

import javax.validation.Valid;

import com.scaef.model.Usuario;
import com.scaef.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Object listar() {
        return usuarioRepository.findAll();
    }

    public void salvar(@Valid Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public void deletar(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

   public Usuario findByNome(String nome){
       return usuarioRepository.findByNome(nome);
   } 
}