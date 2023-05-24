package com.example.Desafio.dto;

public class DependenteResponseDTO  extends DependenteDTO {
    private Long id;

    public DependenteResponseDTO(Long id, String nomeDependente, String cpfDoResponsavel, int idadeDependente) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
