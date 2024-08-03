# Clean Architecture - Gerenciador de Tarefas

## **Conceito de Arquitetura Limpa (Clean Architecture)**

A **Clean Architecture** é um estilo de arquitetura de software proposto por Robert C. Martin (também conhecido como Uncle Bob) que visa criar sistemas com baixa dependência, alta testabilidade, e que sejam facilmente adaptáveis a mudanças. A ideia central é organizar o código de maneira que a lógica de negócio (ou núcleo da aplicação) seja isolada de detalhes externos, como frameworks, bancos de dados, interfaces de usuário, ou APIs externas.

### Principais conceitos da Clean Architecture:

1. **Camadas de Responsabilidade**:
    - **Entidades**: Contém as regras de negócio mais fundamentais. Estas classes são independentes de frameworks, UI, banco de dados ou qualquer outro detalhe de implementação externa.
    - **Use Cases**: Define as regras de aplicação e coordenam as interações entre as entidades e outras camadas. Os casos de uso contêm a lógica que implementa os requisitos específicos de uma aplicação.
    - **Interface Adapters**: Contém implementações que fazem a comunicação entre a lógica de negócios e os frameworks ou serviços externos, como conversores de dados, repositórios, etc.
    - **Frameworks & Drivers**: Contém o código específico de frameworks e a comunicação com dispositivos externos, como bancos de dados, APIs, e a interface do usuário.
2. **Regra da Dependência**:
    - As dependências no código devem sempre apontar para dentro, em direção às camadas mais centrais (Entidades e Use Cases). Isso significa que camadas mais externas (como frameworks e drivers) podem depender de camadas mais internas, mas as camadas internas nunca devem depender das externas.
3. **Isolamento das Camadas**:
    - O código do núcleo de negócios (Entidades e Use Cases) é completamente independente de detalhes de implementação externa. Isso facilita a manutenção, testes e evolução do software, pois você pode alterar as camadas externas sem impactar a lógica de negócios.

A Clean Architecture compartilha muitos princípios com outras arquiteturas como Hexagonal Architecture e Onion Architecture, focando sempre em manter o núcleo de negócios isolado e protegido contra mudanças externas.

## **Gerenciador de Tarefas**

Essa aplicação visa aplicar os conceitos da Arquitetura Limpa, de modo que o usuário possa gerenciar tarefas, permitindo criar, listar, editar e deletar tarefas.

## **Funcionalidades da aplicação**

- [x]  Gerenciar tarefas
- [x]  Criar
- [x]  Listar
- [x]  Editar
- [x]  Deletar

## **Estrutura do Projeto**

1. **Core**
    - **Entidades**: Modelos de dados essenciais para o sistema.
    - **Casos de Uso**: Regras de negócios e lógica da aplicação.
2. **Application**:
    - **Controladores**: Endpoints REST para interagir com a aplicação.
    - **DTOs**: Objetos para transporte de dados entre as camadas.
3. **Infraestructure**:
    - **Repositórios**: Implementações de acesso a dados

## Tecnologias

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2
- Lombok

## Como rodar o projeto
1. Clone esse repositório: 
> git clone https://github.com/KayllaneGPina/clean-architecture-fundamentals.git
2. Rode a classe principal:
> CleanArchitectureApplication.java
3. Use alguma ferramenta para teste de API para rodar um payload de exemplo:
```
{
   "title": "Estudar sobre Arquitetura Limpa",
   "description": "Entender os conceitos iniciais da arquitetura limpa",
   "status": "Pendente"
}
```
4. Resultados
- Post
![post.png](resources\post.png)
- Get
![get.png](resources\get.png)
- Get by ID
![getById.png](resources\getById.png)
- Put
![put.png](resources\put.png)
- Delete
![delete.png](resources\delete.png)

***Obs.: Projeto criado para entender o básico dos conceitos de arquitetura limpa. Aceito feedbacks e dicas de melhorias***