package com.projetos.projetos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projetos.projetos.entities.Projeto;

public interface ProjetoRepository extends MongoRepository<Projeto, String> {}
