package com.example.Desafio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class DependenteDTO {
    private String nomeDependente;
    private String cpfDoResponsavel;
    private int idadeDependente;
}
