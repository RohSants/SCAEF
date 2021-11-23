package com.scaef.scaef_backend.seguranca;

import com.scaef.scaef_backend.model.Usuario;
import com.scaef.scaef_backend.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class UserDetailsServiceImp implements UserDetailsService{ 
 
    @Autowired
    private UsuarioService usuarioService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    Usuario usuario = usuarioService.username(username);
        if(usuario != null){
          SimpleGrantedAuthority sAuthority = new SimpleGrantedAuthority(usuario.getFuncao());
          Set<sAuthority> autorities = new Has
        }
        return null;
    }
}