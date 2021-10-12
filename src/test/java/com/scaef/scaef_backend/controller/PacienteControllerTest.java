package com.scaef.scaef_backend.controller;

import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.dto.PacienteDTO;
import com.scaef.scaef_backend.service.PacienteService;
import com.scaef.scaef_backend.utils.PacienteUtils;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.scaef.scaef_backend.utils.PacienteUtils.asJsonString;

@ExtendWith(MockitoExtension.class)
public class PacienteControllerTest{

    public static final String PACIENTE_API_URL_PATH = "/api/v1/Paciente";
    private MockMvc mockMvc;

    @Mock
    private PacienteService pacienteService;

    @InjectMocks
    private PacienteController pacienteController;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(pacienteController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((viewName, Locale) -> new MappingJackson2JsonView())
            .build();
    }

    @Test
    void testWhenPostMapisCalledThenAPatientShouldBeRegistered() throws Exception  {
        PacienteDTO pacienteDTO = PacienteUtils.createFakePacienteDTO();

        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
        .message("Paciente " + pacienteDTO.getNome() + " cadastrado com a ID = " + pacienteDTO.getId())
        .build();

        when(pacienteService.create(pacienteDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(PACIENTE_API_URL_PATH)
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(pacienteDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
    }
}