package com.projetos.projetos.dto;

import lombok.Data;

@Data
public class ProjetoRequest {
    private String nome;
    private String descricao;
    private String responsavel;
}