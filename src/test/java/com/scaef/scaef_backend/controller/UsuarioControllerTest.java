package com.scaef.scaef_backend.controller;

import com.scaef.scaef_backend.service.UsuarioService;
import com.scaef.scaef_backend.utils.UsuarioUtils;
import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.dto.UsuarioDTO;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.InjectMocks;

import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.scaef.scaef_backend.utils.UsuarioUtils.asJsonString;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    private static final String USUARIO_API_URL_PATH ="/api/v1/Usuario";
    
    private MockMvc mockMvc;

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
            .build();
     }

     @Test
     void testWhenPOSTisCalledThenAUserShouldBeRegistered() throws Exception {
         UsuarioDTO usuarioDTO = UsuarioUtils.createFakeUsuarioDTO();
         MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
         .message("Usuário cadastrado com sucesso com a ID = " + usuarioDTO.getId())
         .build();

    when(usuarioService.create(usuarioDTO)).thenReturn(expectedMessageResponse);

    mockMvc.perform(post(USUARIO_API_URL_PATH)
    .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(usuarioDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
    }
}