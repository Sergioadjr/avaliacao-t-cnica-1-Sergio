package com.example.Desafio.models.familia;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
    private String nomeResponsavel;

    @Column
    private String cpfResponsavel;

    @Column
    private String cpfConjuge;

    @Column
    private int quantidadeDependentes;

    @Column
    private int pontuacaoFinal;

    @Column
    private Double rendaTotal;

    private ListagemFamilia listagemFamilia;

    public Familia(String nomeResponsavel, String cpfResponsavel, String cpfConjuge, int quantidadeDependentes,
            int pontuacaoFinal, Double rendaTotal) {
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.cpfConjuge = cpfConjuge;
        this.quantidadeDependentes = quantidadeDependentes;
        this.pontuacaoFinal = pontuacaoFinal;
        this.rendaTotal = rendaTotal;
        this.listagemFamilia =  listagemFamilia;
    }

    public int calcularPontuacao() {
        int pontuacaoTotal;
        if (rendaTotal <= 900) {
            pontuacaoTotal = 5;
        } else if (rendaTotal >= 901 && rendaTotal <= 1500) {
            pontuacaoTotal = 3;
        } else {
            pontuacaoTotal = 0;
        }

        if (quantidadeDependentes >= 3) {
            pontuacaoTotal += 3;
        } else if (quantidadeDependentes >= 1 && quantidadeDependentes <= 2) {
            pontuacaoTotal += 2;
        } else {
            pontuacaoTotal += 0;
        }
        return pontuacaoTotal;
    }

}
