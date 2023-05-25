package com.example.Desafio.builders;

import com.example.Desafio.models.Familia;

public class FamiliaBuilder {
    private String nomeResponsavel;
    private String cpfResponsavel;
    private String cpfConjuge;
    private int quantidadeDependentes;
    private int pontuacaoFinal;
    private Double rendaTotal;

    public FamiliaBuilder() {
        this.nomeResponsavel = "Sergio";
        this.cpfResponsavel = "321.460.630-17";
        this.cpfConjuge = "654.909.790-89";
        this.quantidadeDependentes = 8;
        this.rendaTotal = 980.00;      
        this.pontuacaoFinal = 8;
    }

    public static FamiliaBuilder builder() {
        return new FamiliaBuilder();
    }

    public FamiliaBuilder nomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
        return this;
    }

    public FamiliaBuilder cpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
        return this;
    }

    public FamiliaBuilder cpfConjuge(String cpfConjuge) {
        this.cpfConjuge = cpfConjuge;
        return this;
    }

    public FamiliaBuilder quantidadeDependentes(int quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
        return this;
    }

    public FamiliaBuilder pontuacaoFinal(int pontuacaoFinal) {
        this.pontuacaoFinal = pontuacaoFinal;
        return this;
    }

    public FamiliaBuilder rendaTotal(Double rendaTotal) {
        this.rendaTotal = rendaTotal;
        return this;
    }

    public Familia build() {
        return new Familia(nomeResponsavel, cpfResponsavel, cpfConjuge, quantidadeDependentes, pontuacaoFinal,
                rendaTotal);
    }
}
