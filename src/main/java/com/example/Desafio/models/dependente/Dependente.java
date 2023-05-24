package com.example.Desafio.models.dependente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name="Dependentes")
public class Dependente extends EntidadeBase{

    @Column
    private String nomeDependente;
   
    @Column
    private String cpfDoResponsavel;

    @Column
    private int idadeDependente;

}
