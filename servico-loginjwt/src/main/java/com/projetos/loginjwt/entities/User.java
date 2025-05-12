package com.projetos.loginjwt.entities;

@Data
@Document(collection = "usuarios")
public class User {
    @Id
        private String id;
        private String username;
        private String password;
        private String role;
}
