package com.example.Desafio.models.familia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.Desafio.utils.EntidadeBase;


public class ListagemFamilia extends EntidadeBase{
    @Column
    @OneToMany (mappedBy = "ListagemFamilia")
    private List<Familia> listaFamilias;

    public class ClassificarFamilias {
        public static List<Familia> classificacaoDasFamilias(List<Familia> familias) {
            List<Familia> listaFamilias = new ArrayList<>(familias);
            listaFamilias.sort(Comparator.comparingInt(Familia::calcularPontuacao));
            return listaFamilias;
        }
    }

}
