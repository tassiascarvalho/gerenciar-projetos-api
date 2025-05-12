package com.projetos.clientes.dto;

import com.projetos.clientes.entities.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteResponse {
    private String id;
    private String nome;
    private String email;
    private Endereco endereco;
}