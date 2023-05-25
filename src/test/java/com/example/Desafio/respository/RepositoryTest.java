package com.example.Desafio.respository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Desafio.models.Familia;
import com.example.Desafio.repository.FamiliaRepository;


@SpringBootTest
public class RepositoryTest {
    @Autowired
    private FamiliaRepository familiaRepository;

    @Test
    public void deve_buscar_familia_por_id() {
        Familia familia = new Familia("João", "123456789", "987654321", 2, 5, 1200.0);
        familiaRepository.save(familia);

        Optional<Familia> encontraFamilia = familiaRepository.findById(familia.getId());

        assertTrue(encontraFamilia.isPresent());
        encontraFamilia.ifPresent(f -> {
            assertEquals(familia.getNomeResponsavel(), f.getNomeResponsavel());
            assertEquals(familia.getCpfResponsavel(), f.getCpfResponsavel());
            assertEquals(familia.getCpfConjuge(), f.getCpfConjuge());
            assertEquals(familia.getQuantidadeDependentes(), f.getQuantidadeDependentes());
            assertEquals(familia.getPontuacaoFinal(), f.getPontuacaoFinal());
            assertEquals(familia.getRendaTotal(), f.getRendaTotal());
        });
    }
}
