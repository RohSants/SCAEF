package com.scaef.scaef_backend.controller;

/*Classes SCAEF*/
import com.scaef.scaef_backend.dto.UsuarioDTO;
import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.service.UsuarioService;
import com.scaef.scaef_backend.exception.UsuarioNotFoundException;

/*Spring Framework*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/Usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @PostMapping
        public MessageResponseDTO create(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.create(usuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable int id) throws UsuarioNotFoundException{ 
        return usuarioService.findById(id);
    }
}