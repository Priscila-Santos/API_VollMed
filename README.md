# 💉 Voll Med API

API REST desenvolvida com **Spring Boot**, **Java 21**, **Maven** e **MySQL** para gerenciamento de médicos, pacientes e consultas da clínica Voll Med.

---

## 📚 Sumário

- [🚀 Tecnologias](#-tecnologias)
- [⚙️ Como executar](#️-como-executar)
- [📦 Estrutura de Pacotes](#-estrutura-de-pacotes)
- [🩺 Funcionalidades](#-funcionalidades)
    - [Cadastro e listagem de médicos](#cadastro-e-listagem-de-médicos)
    - [Cadastro e listagem de pacientes](#cadastro-e-listagem-de-pacientes)
    - [Atualização de dados](#atualização-de-dados)
    - [Exclusão lógica](#exclusão-lógica)
    - [Agendamento e cancelamento de consultas](#agendamento-e-cancelamento-de-consultas)
- [🛠 Regras de Negócio](#-regras-de-negócio)
- [📮 Endpoints](#-endpoints)
- [📌 Notas](#-notas)

---

## 🚀 Tecnologias

- Java 21
- Spring Boot 3.5.3
- Maven
- MySQL
- Jakarta Validation
- Flyway (migração de banco de dados)
- Lombok
- JPA/Hibernate

---

## ⚙️ Como executar

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/vollmed-api.git
cd vollmed-api
```

2. **Configure o banco de dados MySQL:**
```sql
CREATE DATABASE vollmed_api;
```

3. **Configure o `application.properties` ou `application.yml`:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vollmed_api
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
spring.jpa.show-sql=true
```
4. **Execute a aplicação:**
```bash
./mvnw spring-boot:run
```
## 📦 Estrutura de Pacotes
```plaintext
med.voll.api
├── medicos         # Entidades, DTOs e lógica de médicos
├── pacientes       # Entidades, DTOs e lógica de pacientes
├── endereco        # Embeddable e DTOs de endereço
├── controller      # Controladores REST
```

## 🩺 Funcionalidades
✅ Cadastro e listagem de médicos
- Campos obrigatórios: nome, e-mail, telefone, CRM, especialidade e endereço completo (exceto número e complemento).

- Listagem com paginação: 10 por página, ordenados por nome.

✅ Cadastro e listagem de pacientes
- Campos obrigatórios: nome, e-mail, telefone, CPF e endereço completo (exceto número e complemento).

- Listagem com paginação: 10 por página, ordenados por nome.

✅ Atualização de dados
###### Médicos
  - Pode atualizar: nome, telefone e endereço.

  - Não pode atualizar: e-mail, CRM ou especialidade.

###### Pacientes
  - Pode atualizar: nome, telefone e endereço.

  - Não pode atualizar: e-mail ou CPF.

✅ Exclusão lógica
- A exclusão de médicos e pacientes apenas marca como inativo, não apaga os dados do banco.

✅ Agendamento e cancelamento de consultas
- Campos: paciente, médico (opcional), data/hora.

- Regras como horários, indisponibilidades e restrições são respeitadas.

- Cancelamento exige motivo e antecedência mínima de 24 horas.

## 🛠 Regras de Negócio
#### Agendamentos:
- Clínica funciona segunda a sábado, 07:00 às 19:00.

- Consultas duram 1 hora.

- Agendamento com mínimo de 30 minutos de antecedência.

###### Não permitir:

  - Consultas com pacientes ou médicos inativos.
  
  - Duas consultas no mesmo dia para o mesmo paciente.
  
  - Conflito de horário para o mesmo médico.

- Médico pode ser opcional → sistema escolhe aleatoriamente um disponível.

###### Cancelamentos:
- Motivo obrigatório: "paciente desistiu", "médico cancelou" ou "outros".

- Deve ser cancelado com mínimo de 24h de antecedência.

## 📮 Endpoints
| Recurso   | Método | Endpoint          | Descrição                   |
| --------- | ------ | ----------------- | --------------------------- |
| Médicos   | POST   | `/medicos`        | Cadastrar médico            |
| Médicos   | GET    | `/medicos`        | Listar médicos (paginado)   |
| Médicos   | PUT    | `/medicos`        | Atualizar dados permitidos  |
| Médicos   | DELETE | `/medicos/{id}`   | Inativar médico             |
| Pacientes | POST   | `/pacientes`      | Cadastrar paciente          |
| Pacientes | GET    | `/pacientes`      | Listar pacientes (paginado) |
| Pacientes | PUT    | `/pacientes`      | Atualizar dados permitidos  |
| Pacientes | DELETE | `/pacientes/{id}` | Inativar paciente           |
| Consultas | POST   | `/consultas`      | Agendar consulta            |
| Consultas | DELETE | `/consultas`      | Cancelar consulta           |

## 📌 Notas
- O projeto usa validações com Jakarta Bean Validation.

- O banco é versionado com Flyway.

- Uso de Lombok para geração automática de getters, construtores e equals/hashCode.

- Todas as operações respeitam as regras de negócio definidas.