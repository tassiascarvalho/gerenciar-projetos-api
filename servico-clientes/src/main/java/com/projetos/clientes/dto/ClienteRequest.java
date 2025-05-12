package com.projetos.clientes.dto;

import com.projetos.clientes.entities.Endereco;

import lombok.Data;

@Data
public class ClienteRequest {
    private String nome;
    private String email;
    private Endereco endereco;
}