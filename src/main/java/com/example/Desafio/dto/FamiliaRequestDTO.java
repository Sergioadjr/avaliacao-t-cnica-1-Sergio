package com.example.Desafio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FamiliaRequestDTO {
    private String nomeResponsavel;
    private String cpfResponsavel;
    private String cpfConjuge;
    private int quantidadeDependentes;
    private Double rendaTotal;

    public FamiliaRequestDTO(String nomeResponsavel, String cpfResponsavel, String cpfConjuge, Double rendaTotal, int quantidadeDependentes) {
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.cpfConjuge = cpfConjuge;
        this.rendaTotal = rendaTotal;
        this.quantidadeDependentes = quantidadeDependentes;
    }
}
