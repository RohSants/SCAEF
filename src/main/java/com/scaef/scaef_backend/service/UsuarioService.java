package com.scaef.scaef_backend.service;

import javax.validation.Valid;
import com.scaef.scaef_backend.model.Usuario;
import com.scaef.scaef_backend.repository.UsuarioRepository;
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

    public Object logar(String email, String senha){
        return usuarioRepository.Login(email, senha);
    }
}