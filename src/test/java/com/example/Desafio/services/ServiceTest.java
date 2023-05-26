package com.example.Desafio.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Desafio.dto.FamiliaRequestDTO;
import com.example.Desafio.dto.FamiliaResponseDTO;
import com.example.Desafio.models.Familia;
import com.example.Desafio.repository.FamiliaRepository;

@SpringBootTest
public class ServiceTest {
    @Mock
    @Autowired
    private FamiliaRepository familiaRepository;

    @InjectMocks
    @Autowired
    private FamiliaService familiaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deve_criar_uma_familia() {
        FamiliaRequestDTO familiaRequestDTO = new FamiliaRequestDTO();
        familiaRequestDTO.setNomeResponsavel("João");
        familiaRequestDTO.setCpfResponsavel("123456789");
        familiaRequestDTO.setCpfConjuge("987654321");
        familiaRequestDTO.setQuantidadeDependentes(2);
        familiaRequestDTO.setRendaTotal(1200.0);

        when(familiaRepository.save(any(Familia.class))).thenAnswer(invocation -> {
            Familia familia = invocation.getArgument(0);
            familia.setId(1L);
            return familia;
        });

        FamiliaResponseDTO familiaResponseDTO = familiaService.criarFamilia(familiaRequestDTO);

        assertEquals("João", familiaResponseDTO.getNomeResponsavel());
        assertEquals("123456789", familiaResponseDTO.getCpfResponsavel());
        assertEquals("987654321", familiaResponseDTO.getCpfConjuge());
        assertEquals(2, familiaResponseDTO.getQuantidadeDependentes());
        assertEquals(5, familiaResponseDTO.getPontuacaoFinal());
    }

}
