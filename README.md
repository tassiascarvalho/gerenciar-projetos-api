# Gerenciar Projetos API

Este repositório contém a implementação de um sistema distribuído baseado na arquitectura de microsserviços, desenvolvido como estudo de caso para aplicação prática dos conceitos discutidos no trabalho académico sobre **Microservices Architecture**.

## 📌 Objectivo

Demonstrar os princípios fundamentais da arquitectura de microsserviços através da construção de um sistema backend completo, modular, escalável e seguro, utilizando tecnologias modernas como Spring Boot, MongoDB, Kafka, RabbitMQ e API Gateway com validação JWT.

---

## 🧱 Arquitectura de Microsserviços

O sistema é composto pelos seguintes serviços:

| Serviço               | Responsabilidade                                                  | Porta  |
|----------------------|--------------------------------------------------------------------|--------|
| `servico-loginjwt`   | Autenticação e geração de tokens JWT                              | `8081` |
| `servico-usuarios`   | Gestão de utilizadores, cargos e permissões                       | `8082` |
| `servico-clientes`   | Gestão de clientes e respectivos endereços                        | `8083` |
| `servico-projetos`   | Gestão de projectos, integração com Kafka e RabbitMQ              | `8084` |
| `api-gateway`        | Roteamento centralizado e validação de segurança (JWT)            | `8080` |

Cada serviço possui a sua própria base de dados MongoDB e comunica via HTTP REST, Kafka (eventos) e RabbitMQ (notificações).

---

## 🚀 Tecnologias Utilizadas

- **Spring Boot 3** + Spring Web + Spring Security
- **MongoDB** (com Spring Data)
- **Apache Kafka** (eventos de domínio)
- **RabbitMQ** (mensagens assíncronas)
- **Spring Cloud Gateway** (API Gateway com autenticação JWT)
- **Docker** + **Docker Compose**
- **Postman** (testes de endpoints)
- **Lombok**, **JJWT**, entre outras bibliotecas auxiliares

---

## 🐳 Execução com Docker Compose

Certifique-se de ter o [Docker](https://www.docker.com/) e o [Docker Compose](https://docs.docker.com/compose/) instalados.

### 1. Clonar o repositório

```bash
git clone https://github.com/tassiascarvalho/gerenciar-projetos-api.git
cd gerenciar-projetos-api
