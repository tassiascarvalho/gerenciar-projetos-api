package com.projetos.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetos.usuarios.dto.UsuarioRequest;
import com.projetos.usuarios.dto.UsuarioResponse;
import com.projetos.usuarios.entities.Usuario;
import com.projetos.usuarios.repositories.UsuarioRepository;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioResponse(u.getId(), u.getNome(), u.getEmail(), u.getCargo()))
                .toList();
    }

    public UsuarioResponse criar(UsuarioRequest request) {
        Usuario usuario = new Usuario(null, request.getNome(), request.getEmail(), request.getCargo());
        Usuario salvo = usuarioRepository.save(usuario);
        return new UsuarioResponse(salvo.getId(), salvo.getNome(), salvo.getEmail(), salvo.getCargo());
    }

    public Optional<UsuarioResponse> obterPorId(String id) {
        return usuarioRepository.findById(id)
                .map(u -> new UsuarioResponse(u.getId(), u.getNome(), u.getEmail(), u.getCargo()));
    }

    public Optional<UsuarioResponse> atualizar(String id, UsuarioRequest request) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(request.getNome());
            usuario.setEmail(request.getEmail());
            usuario.setCargo(request.getCargo());
            Usuario atualizado = usuarioRepository.save(usuario);
            return new UsuarioResponse(atualizado.getId(), atualizado.getNome(), atualizado.getEmail(), atualizado.getCargo());
        });
    }

    public void deletar(String id) {
        usuarioRepository.deleteById(id);
    }
}