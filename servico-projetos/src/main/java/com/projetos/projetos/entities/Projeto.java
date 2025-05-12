package com.projetos.projetos.entities;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "projetos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private String responsavel;
    private Date dataCriacao;
}