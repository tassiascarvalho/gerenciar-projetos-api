package com.projetos.clientes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String codigoPostal;
}