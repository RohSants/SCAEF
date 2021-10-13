package com.scaef.scaef_backend.service;

import com.scaef.scaef_backend.dto.UsuarioDTO;
import com.scaef.scaef_backend.entity.Usuario;
import com.scaef.scaef_backend.exception.UsuarioNotFoundException;
import com.scaef.scaef_backend.repository.UsuarioRepository;
import com.scaef.scaef_backend.utils.UsuarioUtils;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

@Mock
private UsuarioRepository usuarioRepository;

@InjectMocks
private UsuarioService usuarioService;

@Test
void WhenGivenExistingIdReturnThisUser() throws UsuarioNotFoundException{
    Usuario expectedFoundUsuario = UsuarioUtils.createFakeUsuario();

    Mockito.when(usuarioRepository.findById(expectedFoundUsuario.getId())).thenReturn(Optional.of(expectedFoundUsuario));

    UsuarioDTO usuarioDTO = usuarioService.findById(expectedFoundUsuario.getId());
    
Assertions.assertEquals(expectedFoundUsuario.getNome(), usuarioDTO.getNome());

Assertions.assertEquals(expectedFoundUsuario.getCpf(), usuarioDTO.getCpf());

Assertions.assertEquals(expectedFoundUsuario.getRg(), usuarioDTO.getRg());

Assertions.assertEquals(expectedFoundUsuario.getEmail(), usuarioDTO.getEmail());

Assertions.assertEquals(expectedFoundUsuario.getCelular(), usuarioDTO.getCelular());

Assertions.assertEquals(expectedFoundUsuario.getFone(), usuarioDTO.getFone());

Assertions.assertEquals(expectedFoundUsuario.getFuncao(), usuarioDTO.getFuncao());

Assertions.assertEquals(expectedFoundUsuario.getCrf(), usuarioDTO.getCrf());
 }   
 
@Test
void whenGivenUnexistingIdThenNotFindThrowAnException(){
    var invalidId = 10;

    when(usuarioRepository.findById(invalidId)).thenReturn(Optional.ofNullable(any(Usuario.class)));

    assertThrows(UsuarioNotFoundException.class, () -> usuarioService.findById(invalidId));
    }
}