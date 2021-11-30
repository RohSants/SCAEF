package com.scaef.scaef_backend.seguranca;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import com.scaef.scaef_backend.model.Usuario;
import com.scaef.scaef_backend.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class UserDetailsServiceImp implements UserDetailsService{ 
 
    @Autowired
    private UsuarioService usuarioService;
    

  @Override
  @Transactional 
   public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException{
    Usuario usuario = usuarioService.findByNome(nome);
    if(usuario != null){
      SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.toString());
      Set<GrantedAuthority> authorities = new HashSet<>();
      authorities.add(authority);

      /*User user = new User(usuario.getName(), usuario.getPassword(), authorities);
     return user;*/
    }
		
    return null;
  }
}