package com.scaef.scaef_backend.service;

/*Classes SCAEF*/
import com.scaef.scaef_backend.entity.Usuario;
import com.scaef.scaef_backend.dto.UsuarioDTO;

import java.util.Optional;

import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.repository.UsuarioRepository;
import com.scaef.scaef_backend.mapper.UsuarioMapper;
/*import com.scaef.scaef_backend.exception.PacienteNotFoundException;*/

/*Spring Framework*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;
    
    @Autowired
	public UsuarioService(UsuarioRepository usuarioRepository){
		this.usuarioRepository  = usuarioRepository;
    }
    
    public MessageResponseDTO create(UsuarioDTO usuarioDTO){

        Usuario usuarioToSave = usuarioMapper.toModel(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuarioToSave);

        return MessageResponseDTO.builder().message("Usuário cadastrado no sistema com o ID =  " + savedUsuario.getId()).build();
    }
    public UsuarioDTO findById(int id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return usuarioMapper.toDTO(optionalUsuario.get());
    }
}