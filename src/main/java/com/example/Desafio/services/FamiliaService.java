package com.example.Desafio.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Desafio.dto.FamiliaRequestDTO;
import com.example.Desafio.dto.FamiliaResponseDTO;
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

    public FamiliaResponseDTO criarFamilia(FamiliaRequestDTO familiaRequestDTO) {
        Familia familia = new Familia(familiaRequestDTO.getNomeResponsavel(), familiaRequestDTO.getCpfResponsavel(),
                familiaRequestDTO.getCpfConjuge(), familiaRequestDTO.getQuantidadeDependentes(), 0,
                familiaRequestDTO.getRendaTotal());
        familia.setPontuacaoFinal(familia.calcularPontuacao());

        familiaRepository.save(familia);

        return new FamiliaResponseDTO(familia.getNomeResponsavel(), familia.getCpfResponsavel(),
                familia.getCpfConjuge(),
                familia.getRendaTotal(), familia.getQuantidadeDependentes(), familia.getPontuacaoFinal());
    }

    public List<FamiliaResponseDTO> listagemDeFamiliasOrdenada() {
        List<Familia> familias = StreamSupport.stream(familiaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        List<FamiliaResponseDTO> familiaDTOs = familias.stream()
                .map(familia -> new FamiliaResponseDTO(
                        familia.getNomeResponsavel(),
                        familia.getCpfResponsavel(),
                        familia.getCpfConjuge(),
                        familia.getRendaTotal(),
                        familia.getQuantidadeDependentes(),
                        familia.calcularPontuacao()))
                .collect(Collectors.toList());
        familiaDTOs.sort(
                (familia1, familia2) -> Integer.compare(familia2.getPontuacaoFinal(), familia1.getPontuacaoFinal()));
        return familiaDTOs;
    }

    public FamiliaResponseDTO atualizarFamilia(long id, FamiliaResponseDTO familiaDTO) {
        Familia familia = familiaRepository.findById(id);

        if (familia != null) {
            familia.setRendaTotal(familiaDTO.getRendaTotal());
            familia.setQuantidadeDependentes(familiaDTO.getQuantidadeDependentes());

            familiaRepository.save(familia);

            return new FamiliaResponseDTO(familia.getNomeResponsavel(),
                    familia.getCpfResponsavel(),
                    familia.getCpfConjuge(),
                    familia.getRendaTotal(),
                    familia.getQuantidadeDependentes(),
                    familia.calcularPontuacao());
        } else {
            return null;
        }
    }

    public void excluirFamilia(long id) {
        familiaRepository.deleteById(id);
    }
}