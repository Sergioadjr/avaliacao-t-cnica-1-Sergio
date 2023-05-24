package com.example.Desafio.builders;

import java.util.ArrayList;
import java.util.List;

import com.example.Desafio.models.dependente.Dependente;
import com.example.Desafio.models.familia.Familia;

public class FamiliaBuilder {

    private String nomeResponsavel;
    private String cpfResponsavel;
    private String cpfConjuge;
    private List<Dependente> dependente;
    private int pontuacaoFinal;

    public FamiliaBuilder() {
        this.nomeResponsavel = "Sergio";
        this.cpfResponsavel = "321.460.630-17";
        this.cpfConjuge = "654.909.790-89";
        this.dependente = new ArrayList<>();
        this.pontuacaoFinal = 3;
    }

    public Familia construir() {
        return new Familia(nomeResponsavel, cpfResponsavel, cpfConjuge, dependente, pontuacaoFinal);
    }

    public FamiliaBuilder comNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
        return this;
    }

    public FamiliaBuilder comCpfDoResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
        return this;
    }

    public FamiliaBuilder comCpfConjuge(String cpfConjuge) {
        this.cpfConjuge = cpfConjuge;
        return this;
    }

    public FamiliaBuilder comDependente(List<Dependente> dependente) {
        this.dependente = dependente ;
        return this;
    }

    public FamiliaBuilder comPontuacaoFinal(int pontuacaoFinal) {
        this.pontuacaoFinal = pontuacaoFinal;
        return this;
    }
}