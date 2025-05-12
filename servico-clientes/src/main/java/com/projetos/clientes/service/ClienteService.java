package com.projetos.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.clientes.dto.ClienteRequest;
import com.projetos.clientes.dto.ClienteResponse;
import com.projetos.clientes.entities.Cliente;
import com.projetos.clientes.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteResponse> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(c -> new ClienteResponse(c.getId(), c.getNome(), c.getEmail(), c.getEndereco()))
                .toList();
    }

    public ClienteResponse criar(ClienteRequest request) {
        Cliente cliente = new Cliente(null, request.getNome(), request.getEmail(), request.getEndereco());
        Cliente salvo = clienteRepository.save(cliente);
        return new ClienteResponse(salvo.getId(), salvo.getNome(), salvo.getEmail(), salvo.getEndereco());
    }

    public Optional<ClienteResponse> obterPorId(String id) {
        return clienteRepository.findById(id)
                .map(c -> new ClienteResponse(c.getId(), c.getNome(), c.getEmail(), c.getEndereco()));
    }

    public Optional<ClienteResponse> atualizar(String id, ClienteRequest request) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(request.getNome());
            cliente.setEmail(request.getEmail());
            cliente.setEndereco(request.getEndereco());
            Cliente atualizado = clienteRepository.save(cliente);
            return new ClienteResponse(atualizado.getId(), atualizado.getNome(), atualizado.getEmail(), atualizado.getEndereco());
        });
    }

    public void deletar(String id) {
        clienteRepository.deleteById(id);
    }
}
