package com.example.Desafio.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Desafio.dto.FamiliaDTO;
import com.example.Desafio.models.Familia;
import com.example.Desafio.repository.FamiliaRepository;

@Service
public class FamiliaService {

    @Autowired
    private final FamiliaRepository familiaRepository;

    @Autowired
    public FamiliaService(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    public FamiliaDTO criarFamilia(FamiliaDTO familiaDTO) {
        Familia familia = new Familia(familiaDTO.getNomeResponsavel(), familiaDTO.getCpfResponsavel(),
                familiaDTO.getCpfConjuge(), familiaDTO.getQuantidadeDependentes(), 0, familiaDTO.getRendaTotal());
        familiaRepository.save(familia);

        return new FamiliaDTO(familia.getRendaTotal(), familia.getQuantidadeDependentes(), familia.calcularPontuacao());
    }

    public List<FamiliaDTO> listagemDeFamiliasOrdenada() {
        List<Familia> familias = StreamSupport.stream(familiaRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());


        List<FamiliaDTO> familiaDTOs = familias.stream()
                .map(familia -> new FamiliaDTO(
                        familia.getRendaTotal(),
                        familia.getQuantidadeDependentes(),
                        familia.calcularPontuacao()))
                .collect(Collectors.toList());
        familiaDTOs.sort(
                (familia1, familia2) -> Integer.compare(familia2.getPontuacaoFinal(), familia1.getPontuacaoFinal()));
        return familiaDTOs;
    }

    public FamiliaDTO atualizarFamilia(long id, FamiliaDTO familiaDTO) {
        Familia familia = familiaRepository.findById(id);

        if (familia != null) {
            familia.setRendaTotal(familiaDTO.getRendaTotal());
            familia.setQuantidadeDependentes(familiaDTO.getQuantidadeDependentes());

            familiaRepository.save(familia);

            return new FamiliaDTO(familia.getRendaTotal(), familia.getQuantidadeDependentes(),
                    familia.calcularPontuacao());
        } else {
            return null;
        }
    }

    public void excluirFamilia(long id) {
        familiaRepository.deleteById(id);
    }
}