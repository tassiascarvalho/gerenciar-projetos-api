package com.projetos.usuarios.dto;

import com.projetos.usuarios.enums.Cargo;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String nome;
    private String email;
    private Cargo cargo;
}
