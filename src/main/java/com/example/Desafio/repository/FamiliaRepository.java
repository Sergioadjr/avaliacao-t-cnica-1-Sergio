package com.example.Desafio.repository;

import org.springframework.stereotype.Repository;

import com.example.Desafio.models.familia.Familia;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface FamiliaRepository extends CrudRepository<Familia, Long> {

    Familia findByCpfResponsavel(String cpfResponsavel);

    @Query("SELECT f FROM Familias f ORDER BY f.pontuacaoFinal DESC")List<Familia> findAllOrderByPontuacaoFinalDesc();

}
