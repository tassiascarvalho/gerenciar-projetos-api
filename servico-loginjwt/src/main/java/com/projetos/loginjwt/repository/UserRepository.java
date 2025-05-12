package com.projetos.loginjwt.repository;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}