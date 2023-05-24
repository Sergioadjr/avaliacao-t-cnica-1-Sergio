package com.example.Desafio.models.familia;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.Desafio.models.dependente.Dependente;
import com.example.Desafio.utils.EntidadeBase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Familia extends EntidadeBase {

    @Column
    private String nomeResponsavel;
    
    @Column
    private String cpfResponsavel;
    @Column
    private String cpfConjuge;
    
    @Column
    @OneToMany
    private List <Dependente> dependente;
    @Column
    private int pontuacaoFinal;

}
