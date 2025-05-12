package com.projetos.usuarios.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projetos.usuarios.entities.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}