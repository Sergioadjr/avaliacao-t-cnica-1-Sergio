package com.example.Desafio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FamiliaDTO {
    private String nomeResponsavel;
    private String cpfResponsavel;
    private String cpfConjuge;
    private int quantidadeDependentes;
    private Double rendaTotal;
    private int pontuacaoFinal;

    public FamiliaDTO(Double rendaTotal, int quantidadeDependentes, int pontuacaoFinal) {
        this.rendaTotal = rendaTotal;
        this.quantidadeDependentes = quantidadeDependentes;
        this.pontuacaoFinal = pontuacaoFinal;
    }
}


