package com.example.Desafio.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Desafio.dto.FamiliaDTO;
import com.example.Desafio.repository.FamiliaRepository;
import com.example.Desafio.services.FamiliaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/familias")
public class FamiliaController {

    @Autowired
    FamiliaRepository familiaRepository;

    @Autowired
    FamiliaService familiaService;

    @Autowired
    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @DeleteMapping(path = "/{id}")
    public void excluirFamilia(@PathVariable Long id) {
        familiaRepository.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<FamiliaDTO>> listagemDeFamiliasOrdenada() {
        List<FamiliaDTO> familiaDTOs = familiaService.listagemDeFamiliasOrdenada();
        return ResponseEntity.ok(familiaDTOs);
    }

    @PostMapping
    public ResponseEntity<FamiliaDTO> criarFamilia(@RequestBody FamiliaDTO familiaDTO) {
        FamiliaDTO novaFamiliaDTO = familiaService.criarFamilia(familiaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFamiliaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliaDTO> atualizarFamilia(@PathVariable("id") long id,
            @RequestBody FamiliaDTO familiaDTO) {
        FamiliaDTO familiaAtualizadaDTO = familiaService.atualizarFamilia(id, familiaDTO);
        if (familiaAtualizadaDTO != null) {
            return ResponseEntity.ok(familiaAtualizadaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}