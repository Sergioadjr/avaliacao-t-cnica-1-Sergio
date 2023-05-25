package com.example.Desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Desafio.models.Familia;

@Repository
public interface FamiliaRepository extends CrudRepository<Familia, Long> {
    Familia findById(long id);
}
