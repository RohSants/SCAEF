package com.scaef.scaef_backend.mapper;

/*Classes SCAEF*/
import com.scaef.scaef_backend.entity.Usuario;
import com.scaef.scaef_backend.dto.UsuarioDTO;

/*MapStruct*/
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toModel(UsuarioDTO usuarioDTO);
}