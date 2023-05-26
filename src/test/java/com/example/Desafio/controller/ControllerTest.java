package com.example.Desafio.controller;

import com.example.Desafio.controllers.FamiliaController;
import com.example.Desafio.dto.FamiliaRequestDTO;
import com.example.Desafio.dto.FamiliaResponseDTO;
import com.example.Desafio.services.FamiliaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ControllerTest {
    @Mock
    private FamiliaService familiaService;

    private FamiliaController familiaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        familiaController = new FamiliaController(familiaService);
    }

    @Test
    void deve_verificar_o_retorno_da_chamada_na_de_listagem() {
        List<FamiliaResponseDTO> familiaDTOs = new ArrayList<>();
        familiaDTOs.add(new FamiliaResponseDTO());
        when(familiaService.listagemDeFamiliasOrdenada()).thenReturn(familiaDTOs);

        ResponseEntity<List<FamiliaResponseDTO>> response = familiaController.listagemDeFamiliasOrdenada();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());

        verify(familiaService, times(1)).listagemDeFamiliasOrdenada();
    }

    @Test
    void deve_verificar_o_retorno_da_chamada_ao_criar_uma_familia() {
        FamiliaRequestDTO familiaRequestDTO = new FamiliaRequestDTO();
        FamiliaResponseDTO novaFamiliaDTO = new FamiliaResponseDTO();
        when(familiaService.criarFamilia(familiaRequestDTO)).thenReturn(novaFamiliaDTO);

        ResponseEntity<FamiliaResponseDTO> response = familiaController.criarFamilia(familiaRequestDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertNotNull(response.getBody());

        verify(familiaService, times(1)).criarFamilia(familiaRequestDTO);
    }

    @Test
    void deve_verificar_o_retorno_da_chamada_ao_atualizar_uma_familia() {
        long id = 1L;
        FamiliaResponseDTO familiaDTO = new FamiliaResponseDTO();
        FamiliaResponseDTO familiaAtualizadaDTO = new FamiliaResponseDTO();
        when(familiaService.atualizarFamilia(id, familiaDTO)).thenReturn(familiaAtualizadaDTO);

        ResponseEntity<FamiliaResponseDTO> response = familiaController.atualizarFamilia(id, familiaDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());

        verify(familiaService, times(1)).atualizarFamilia(id, familiaDTO);
    }

    @Test
    void deve_verificar_o_retorno_da_chamada_ao_atualizar_familia_id() {
        long id = 1L;
        FamiliaResponseDTO familiaDTO = new FamiliaResponseDTO();
        when(familiaService.atualizarFamilia(id, familiaDTO)).thenReturn(null);

        ResponseEntity<FamiliaResponseDTO> response = familiaController.atualizarFamilia(id, familiaDTO);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        assertEquals(null, response.getBody());

        verify(familiaService, times(1)).atualizarFamilia(id, familiaDTO);
    }
}