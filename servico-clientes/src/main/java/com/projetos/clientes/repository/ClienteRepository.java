package com.projetos.clientes.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projetos.clientes.entities.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByEmail(String email);
}
