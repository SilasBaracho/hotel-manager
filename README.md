# Hotel Manager API

## Descrição

**Hotel Manager API** é um serviço responsável pelo gerenciamento dos hoteis e reservas.

## Funcionalidades

- Buscar quartos disponíveis em hotéis por período.
- Reservar quartos para hóspedes.
- Integração com Kafka para processamento assíncrono de eventos.
- Thymeleaf como motor de templates para notificações.
- PostgreSQL como banco de dados relacional.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **PostgreSQL** - Para publicação e consumo de eventos de notificação.
- **Kafka** - Para publicação e consumo de eventos de notificação.
- **Schema Registry** - Para gerenciamento de esquemas de mensagens.
- **Thymeleaf** - Motor de templates para geração de emails.
- **Docker** - Para containerização da aplicação.
- **Maven** - Para gerenciamento de dependências e build.

## Requisitos

- **Java 21**
- **Kafka**
- **Schema Registry**

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/SilasBaracho/hotel-manager.git

2. Execute o comando:

- O comando irá baixar todas as dependências do projeto, declaradas no docker-compose.yml 

    ```bash
    make start
  
3. Link do Repositório do serviço de notificação.

    ```bash
    https://github.com/SilasBaracho/notification-service-api

## Utilização

A API oferece um endpoint REST para gerenciar o hotel.

### Endpoints

#### Endpoint:  

- **URL**: `/api/v1/room/find-room-available`
- **Método**: `GET`
- **Descrição**: Retorna uma lista de quartos disponíveis em uma localidade para um determinado período.

#### Endpoint:

- **URL**: `/api/v1/hotel/find-by-locale`
- **Método**: `GET`
- **Descrição**: Retorna uma lista hoteis de acordo com a localidade.

#### Endpoint:

- **URL**: `/api/v1/booking/{id_guest}`
- **Método**: `GET`
- **Descrição**: Retorna todas as reservas associadas a um determinado hóspede.

#### Endpoint:

- **URL**: `/api/v1/booking`
- **Método**: `POST`
- **Descrição**:  Cria uma nova reserva para um hóspede.


### Exemplo de Requisição

#### Request

```http 
curl -X GET "http://localhost:8080/api/v1/room/find-room-available?locale=recife&check_in=2024-09-10&check_out=2024-09-15"
```
```http 
curl -X GET "http://localhost:8080/api/v1/hotel/find-by-locale?locale=recife"
``` 
```http 
curl -X GET "http://localhost:8080/api/v1/booking/{id_guest}"
``` 
```http 
curl -X POST "http://localhost:8080/api/v1/booking" \
  -H "Content-Type: application/json" \
  -d '{
    "idRoom": "uuid",
    "idHotel": "uuid",
    "idGuest": "uuid",
    "guestEmail": "guest@example.com",
    "guestPhone": "+5511999999999",
    "checkIn": "2024-09-10",
    "checkOut": "2024-09-15"
}'
```