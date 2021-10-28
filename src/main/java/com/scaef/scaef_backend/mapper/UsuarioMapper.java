package com.scaef.scaef_backend.mapper;

import com.scaef.scaef_backend.dto.UsuarioDTO;
import com.scaef.scaef_backend.model.Usuario;

/*MapStruct*/
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toModel(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);
}