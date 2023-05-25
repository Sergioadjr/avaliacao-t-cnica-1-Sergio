package com.example.Desafio.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.example.Desafio.exception.IdadeInvalidaException;
import com.example.Desafio.utils.EntidadeBase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Familia extends EntidadeBase {

    @Column
    @NotBlank
    private String nomeResponsavel;
    
    @Column
    @NotBlank
    private String cpfResponsavel;

    @Column
    private String cpfConjuge;

    @Column
    private int quantidadeDependentes;

    @Column
    private int pontuacaoFinal;

    @Column
    private Double rendaTotal;


    public Familia(String nomeResponsavel, String cpfResponsavel, String cpfConjuge, int quantidadeDependentes,
            int pontuacaoFinal, Double rendaTotal) {
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.cpfConjuge = cpfConjuge;
        this.quantidadeDependentes = quantidadeDependentes;
        this.pontuacaoFinal = pontuacaoFinal;
        this.rendaTotal = rendaTotal;
    }

    public int calcularPontuacao() {
        int pontuacaoFinal;
        if (rendaTotal <= 900) {
            pontuacaoFinal = 5;
        } else if (rendaTotal >= 901 && rendaTotal <= 1500) {
            pontuacaoFinal = 3;
        } else {
            pontuacaoFinal = 0;
        }

        if (quantidadeDependentes >= 3) {
            pontuacaoFinal += 3;
        } else if (quantidadeDependentes >= 1 && quantidadeDependentes <= 2) {
            pontuacaoFinal += 2;
        } else {
            pontuacaoFinal += 0;
        }
        return pontuacaoFinal;
    }

    
}
