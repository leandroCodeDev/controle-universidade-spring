
# Sistema de Gerenciamento de Cursos e Alunos de uma Universidade

## PROJETO

Este é um sistema de gerenciamento de cursos e alunos de uma universidade, seja para um colégio ou universidade. Foi criado como um exercício do curso [Floripa Mais Tec](https://floripamaistec.pmf.sc.gov.br), durante o módulo de Spring, lecionado por [André Nunes](https://github.com/andresnunes) e [Gabriel Augustin](https://github.com/AugustinGabriel).

## TECH

- [Java](https://www.java.com/pt-BR/download/help/whatis_java.html)
- [Spring](https://spring.io/)

## FERRAMENTAS

- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)
- [Insomnia](https://insomnia.rest/)
- [Trello](https://trello.com/pt-BR)

## Pré-requisitos

- JDK 21 ou superior instalado
- Git instalado na sua máquina
- IntelliJ IDEA

## Dependências

- Spring Web
- Spring Boot DevTools

## Getting Started

### Instalação

**Clonando o Repositório**

```bash
git clone https://github.com/leandroCodeDev/controle-universidade-spring.git
```

### Executando

Abra a pasta "controle-universidade-spring" no IntelliJ IDEA e inicie o projeto utilizando o atalho RUN da IDE.

### Acessando a API

Por padrão, a porta configurada no projeto é a 8090 (http://localhost:8090).

## Rotas

### ENDPOINT - `aluno`

#### [POST] - `aluno`

| Parâmetro       | Descrição                                      |
|-----------------|------------------------------------------------|
| `nome`          | Nome do Aluno                                  |
| `dataNascimento`| Data de nascimento do aluno no padrão `"dd/MM/yyyy"` |

+ Request (application/json)

    + Body

            {
              "nome": "Leandro",
              "dataNascimento": "01/01/2024"
            }

+ Response 200 (application/json)

    + Body

            {
              "id": 1,
              "nome": "Leandro",
              "dataNascimento": "01/01/2024"
            }

#### [GET] - `aluno`
+ Request (application/json)

+ Response 200 (application/json)

        [
          {
            "id": 1,
            "nome": "Leandro",
            "dataNascimento": "01/01/2024"
          },
          {
            "id": 2,
            "nome": "Maria",
            "dataNascimento": "02/02/2024"
          }
        ]

#### [GET] - `aluno/{id}`
+ Request (application/json)

+ Response 200 (application/json)

        {
          "id": 1,
          "nome": "Leandro",
          "dataNascimento": "01/01/2024"
        }

#### [PUT] - `aluno/{id}`

+ Request (application/json)

    + Body

            {
              "nome": "Leandro",
              "dataNascimento": "01/01/2025"
            }

+ Response 200 (application/json)

    + Body

            {
              true
            }

#### [DELETE] - `aluno/{id}`
+ Request (application/json)

+ Response 200 (application/json)

        {
            true
        }

### ENDPOINT - `curso`

#### [POST] - `curso`

| Parâmetro      | Descrição              |
|----------------|------------------------|
| `nome`         | Nome do curso          |
| `descricao`    | Descrição do curso     |
| `cargaHoraria` | Carga horária do curso |

+ Request (application/json)

    + Body

            {
              "nome": "CCO",
              "descricao": "Ciência da Computação",
              "cargaHoraria": 100
            }

+ Response 200 (application/json)

    + Body

            {
              "id": 1,
              "nome": "CCO",
              "descricao": "Ciência da Computação",
              "cargaHoraria": 100,
              "alunos": []
            }

#### [GET] - `curso`
+ Request (application/json)

+ Response 200 (application/json)

        [
          {
            "id": 1,
            "nome": "CCO",
            "descricao": "Ciência da Computação",
            "cargaHoraria": 100,
            "alunos": []
          },
          {
            "id": 2,
            "nome": "SI",
            "descricao": "Sistemas de Informação",
            "cargaHoraria": 120,
            "alunos": []
          }
        ]

#### [GET] - `curso/{id}`
+ Request (application/json)

+ Response 200 (application/json)

        {
          "id": 1,
          "nome": "CCO",
          "descricao": "Ciência da Computação",
          "cargaHoraria": 100,
          "alunos": []
        }

#### [PUT] - `curso/{id}`

+ Request (application/json)

    + Body

            {
              "nome": "CCO",
              "descricao": "Ciência da Computação Atualizada",
              "cargaHoraria": 150
            }

+ Response 200 (application/json)

    + Body

            {
              true
            }

#### [DELETE] - `curso/{id}`
+ Request (application/json)

+ Response 200 (application/json)

        {
            true
        }

#### [POST] - `curso/{id}/matricular`

| Parâmetro | Descrição                     |
|-----------|-------------------------------|
| `idAluno` | Código identificador do aluno |

+ Request (application/json)

    + Body

            {
              "idAluno": 1
            }

+ Response 200 (application/json)

    + Body

            {
              true
            }

## Pontos de Melhoria para Esse Projeto

- **Adicionar comunicação com banco de dados:** Implementar uma integração com um sistema de banco de dados, como MySQL, PostgreSQL ou MongoDB, para persistência de dados de alunos e cursos, substituindo o armazenamento em memória ou soluções temporárias.

- **Melhorar os retornos da API:** Refinar os retornos da API para fornecer respostas mais detalhadas e úteis em caso de sucesso ou falha nas operações. Isso inclui retornar mensagens de erro claras e específicas, além de códigos de status HTTP apropriados para cada situação.

- **Adicionar um tratamento de erro personalizado** Desenvolver um sistema de tratamento de erros que capture exceções específicas da aplicação, permitindo retornos mais informativos e uma melhor experiência para o usuário da API. Isso pode incluir a criação de uma classe de exceção personalizada e um manipulador de exceções global.
