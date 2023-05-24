package com.example.Desafio.builders;

import com.example.Desafio.exception.IdadeInvalidaException;
import com.example.Desafio.models.dependente.Dependente;

public class DependenteBuilder {

    private String nomeDependente;
    private String cpfDoResponsavel;
    private int idadeDependente;

    public DependenteBuilder() {
        this.nomeDependente = "Sergio";
        this.cpfDoResponsavel = "546.326.810-08";
        this.idadeDependente = 17;
    }

    public DependenteBuilder comNome(String nomeDependente) {
        this.nomeDependente = nomeDependente;
        return this;
    }

    public DependenteBuilder comIdadeMaior(int idadeDependente) throws IdadeInvalidaException {
        this.idadeDependente = idadeDependente;
        return this;
    }

    public DependenteBuilder comIdadeMenor(int idadeDependente) {
        this.idadeDependente = idadeDependente;
        return this;
    }

    public DependenteBuilder comCpfDoResponsavel(String cpfDoResponsavel) {
        this.cpfDoResponsavel = cpfDoResponsavel;
        return this;
    }

    public Dependente construir() {
        return new Dependente(nomeDependente, cpfDoResponsavel, idadeDependente);
    }
}
