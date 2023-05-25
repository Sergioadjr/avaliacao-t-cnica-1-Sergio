package com.example.Desafio.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Desafio.builders.FamiliaBuilder;
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

    // @Test
    // public void deve_criar_uma_lista_ordenada_pela_maio_pontuacao() {
    //     Familia familia1 = new FamiliaBuilder().rendaTotal(899.20).quantidadeDependentes(5).build();
    //     Familia familia2 = new FamiliaBuilder().rendaTotal(2400.10).quantidadeDependentes(1).build();
    //     Familia familia3 = new FamiliaBuilder().rendaTotal(1800.00).quantidadeDependentes(10).build();

    //     int pontuacaoFamilia1 = familia1.calcularPontuacao();
    //     int pontuacaoFamilia2 = familia2.calcularPontuacao();
    //     int pontuacaoFamilia3 = familia3.calcularPontuacao();

    //     List<FamiliaResponseDTO> esperaFamiliaDTOs = new ArrayList<>();
    //     esperaFamiliaDTOs.add(
    //             new FamiliaResponseDTO("Antonio", "742.979.470-05", "067.615.270-82", 899.20, 5, pontuacaoFamilia1));
    //     esperaFamiliaDTOs.add(
    //             new FamiliaResponseDTO("Maria", "068.662.690-75", "109.981.990-36", 1800.00, 10, pontuacaoFamilia3));
    //     esperaFamiliaDTOs.add(
    //             new FamiliaResponseDTO("Giovana", "213.255.710-16", "298.090.530-53", 2400.10, 1, pontuacaoFamilia2));

    //     familiaRepository.save(familia1);
    //     familiaRepository.save(familia2);
    //     familiaRepository.save(familia3);

    //     List<FamiliaResponseDTO> atualFamiliaDTOs = familiaService.listagemDeFamiliasOrdenada();

    //     Assertions.assertEquals(esperaFamiliaDTOs, atualFamiliaDTOs);
    // }

    @Test
    public void testAtualizarFamilia_ExistingFamilia() {
        long id = 1L;

    }
}
