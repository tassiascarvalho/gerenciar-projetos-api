package com.projetos.projetos.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjetoResponse {
    private String id;
    private String nome;
    private String descricao;
    private String responsavel;
    private Date dataCriacao;
}