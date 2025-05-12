package com.projetos.usuarios.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import com.projetos.usuarios.enums.Cargo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @org.springframework.data.annotation.Id
    private String id;
    private String nome;
    private String email;
    private Cargo cargo;
}