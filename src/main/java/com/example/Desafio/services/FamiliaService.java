package com.example.Desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Desafio.dto.FamiliaRequestDTO;
import com.example.Desafio.dto.FamiliaResponseDTO;
import com.example.Desafio.models.familia.Familia;
import com.example.Desafio.repository.FamiliaRepository;

@Service
public class FamiliaService {
    @Autowired
    private FamiliaRepository familiaRepository;
    
    public void removerPorId(Long id){
        familiaRepository.deleteById(id);
    }

    public FamiliaResponseDTO criar(FamiliaRequestDTO FamiliaRequestDTO) {
        Familia familia = familiaRepository.save(familia);
        return FamiliaResponseDTO;
    }

    
}
