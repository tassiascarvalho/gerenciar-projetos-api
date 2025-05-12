package com.projetos.projetos.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.projetos.projetos.dto.ProjetoRequest;
import com.projetos.projetos.dto.ProjetoResponse;
import com.projetos.projetos.entities.Projeto;
import com.projetos.projetos.repository.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${projetos.kafka.topic}")
    private String kafkaTopic;

    @Value("${projetos.rabbitmq.queue}")
    private String rabbitQueue;

    public List<ProjetoResponse> listarTodos() {
        return projetoRepository.findAll()
                .stream()
                .map(p -> new ProjetoResponse(p.getId(), p.getNome(), p.getDescricao(), p.getResponsavel(), p.getDataCriacao()))
                .toList();
    }

    public ProjetoResponse criar(ProjetoRequest request) {
        Projeto projeto = new Projeto(null, request.getNome(), request.getDescricao(), request.getResponsavel(), new Date(0));
        Projeto salvo = projetoRepository.save(projeto);

        // Publica evento Kafka
        kafkaTemplate.send(kafkaTopic, "Projeto criado: " + salvo.getNome());

        // Envia notificação RabbitMQ
        rabbitTemplate.convertAndSend(rabbitQueue, "Novo projeto criado: " + salvo.getNome());

        return new ProjetoResponse(salvo.getId(), salvo.getNome(), salvo.getDescricao(), salvo.getResponsavel(), salvo.getDataCriacao());
    }

    public Optional<ProjetoResponse> obterPorId(String id) {
        return projetoRepository.findById(id)
                .map(p -> new ProjetoResponse(p.getId(), p.getNome(), p.getDescricao(), p.getResponsavel(), p.getDataCriacao()));
    }

    public Optional<ProjetoResponse> atualizar(String id, ProjetoRequest request) {
        return projetoRepository.findById(id).map(projeto -> {
            projeto.setNome(request.getNome());
            projeto.setDescricao(request.getDescricao());
            projeto.setResponsavel(request.getResponsavel());
            Projeto atualizado = projetoRepository.save(projeto);
            return new ProjetoResponse(atualizado.getId(), atualizado.getNome(), atualizado.getDescricao(), atualizado.getResponsavel(), atualizado.getDataCriacao());
        });
    }

    public void deletar(String id) {
        projetoRepository.deleteById(id);
    }
}
