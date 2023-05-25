package com.example.Desafio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Desafio.models.Familia;

@Repository
public interface FamiliaRepository extends CrudRepository<Familia, Long> {
    Optional<Familia>  findById(long id);
}
