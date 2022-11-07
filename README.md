# Plataforma de cursos online da Fatec Zona Leste
<fig>
<img src="https://rockcontent.com/br/wp-content/uploads/sites/2/elementor/thumbs/modelo-de-projeto-p2he6clp7uhmwqd16ikv9jgz30a5liixoon908hej0.png" alt="Uma imagem relacionada ao projeto">
<figcaption>Uma imagem relacionada ao projeto</figcaption>
</fig>

## Inicialização
Para executar o projeto, utilize as ferramentas descritas na sessão *Ferramentas*.

## Ferramentas
* Spring Boot - Spring Tools for Eclipse IDE (https://spring.io/projects/spring-boot) - IDE para desenvolvimento.

## Links importantes
* [Spring Boot Rest API](https://medium.com/better-programming/building-a-spring-boot-rest-api-a-php-developers-view-part-i-6add2e794646) -  API com Spring Boot - camada servidor.

* [Angular Framework](https://angular.io/) - camada cliente.

# FatecFlix

## Introdução

Este projeto possui o objetivo principal **implementar uma plataforma de cursos online da Fatec Zona Leste**.  
<<<<<<< HEAD
Com os objetivos gerais de gerenciamento cursos voltados para o nivelamento de alunos ingressantes da graduação.
=======
Com os objetivos gerais de gerenciamento cursos voltados para o nivelamento de alunos ingressantes da graduação. 
>>>>>>> ce21c7dc02117b822430e24805d93f0ab6fab6fa

## Análise técnica

### Descrição do ambiente técnico

O sistema é composto por um banco de dados, uma interface web e um sistema embarcado. Funcionalidades principais:
> Indique os grandes blocos do sistema.

* **F1** - Nome da funcionalidade 1.
* **F2** - Nome da funcionalidade 2.
* **F3** - Nome da funcionalidade 3.
> Coloque somente o nome principal, por exemplo: Controle de usuários.

As ferramentas utilizadas para o desenvolvimento incluem **< linguagem para back-end >** que é uma linguagem de programação utilizada para o Back-end, para front-end foi utilizado **< linguagem para o front-end >** . **< Banco de dados >** atuando como sistema gerenciador de banco de dados relacional e **< gerenciador de container >** para utilizar o ambiente em container.

<<<<<<< HEAD
### Levantamento de requisitos
=======
### Levantamento de requisitos  
>>>>>>> ce21c7dc02117b822430e24805d93f0ab6fab6fa
Os requisitos devem ser validados com a cliente e aprovados.
> Aprovar os requisitos com o cliente é o mais importante, se não for validado o documento não será válido.

### Requisitos Funcionais
Respeitando a proposta, o sistema deverá atender os seguintes requisitos:

* **RF1** - O usuário deve poder realizar as operações de cadastro, consulta, alteração e exclusão de seus dados.
* **RF2** - O instrutor deve poder cadastrar, consultar, alterar ou excluir cursos.
* **RF3** - O usuário deve poder se matricular, cancelar matrícula e acompanhar seu progresso nos cursos disponíveis.

## Regras de Negócio

<<<<<<< HEAD
_Solicitação_

**RGN1** -  O cliente só fará a solicitação se estiver cadastrado e logado.

_Agendamento_

**RGN2** - O cliente só fará a agendamento se estiver 2 anos no sistema.
=======
_Solicitação_  

**RGN1** -  O cliente só fará a solicitação se estiver cadastrado e logado.  

_Agendamento_  

**RGN2** - O cliente só fará a agendamento se estiver 2 anos no sistema.   
>>>>>>> ce21c7dc02117b822430e24805d93f0ab6fab6fa

> As regras de negócio estão relacionadas as dependencias do sistema, por exemplo "depois de x tempo" ou "para clientes de x perfil".

## Especificação de Requisitos: Estórias de usuário

**REQ01** - *Cadastrar usuário*

    Como – usuário
    Eu quero – realizar meu cadastro na plataforma
    De maneira que – seja possível visualizar cursos em andamento e realizar matrículas em novos cursos disponíveis na plataforma.

**REQ02** - *Consultar Perfil do Usuário*

    Como – usuário
    Eu quero – visualizar as informações que cadastrei no meu perfil
    De maneira que – seja possível visualizar se há informações inconsistentes


**REQ03** - *Atualizar informações do usuário*

    Como – usuário
    Eu quero – alterar os meus dados
    De maneira que – seja possível atualizar informações inconsistentes
<<<<<<< HEAD


=======
 
 
>>>>>>> ce21c7dc02117b822430e24805d93f0ab6fab6fa
**REQ04** - *Excluir perfil*

    Como – usuário
    Eu quero –  excluir o meu perfil
    De maneira que – os dados sejam deletados permanentemente do sistema
<<<<<<< HEAD


=======
    
    
>>>>>>> ce21c7dc02117b822430e24805d93f0ab6fab6fa
**REQ05** - *Cadastrar curso*

    Como – instrutor
    Eu quero –  criar um curso
    De maneira que –  seja possível para outros usuários matricularem-se e visualizar a trilha do curso
<<<<<<< HEAD


=======
    
    
>>>>>>> ce21c7dc02117b822430e24805d93f0ab6fab6fa
**REQ06** - *Consultar curso*

    Como – usuário
    Eu quero –  consultar um curso
    De maneira que –  seja possível obter informações para saber as aulas que compõe o curso


**REQ07** - *Atualizar informações do curso*

    Como – instrutor
    Eu quero –  alterar as informações de um curso
    De maneira que –  seja possível atualizar informações do curso e adicionar novas aulas


**REQ08** - *Excluir curso*

    Como – instrutor
    Eu quero –  realizar matrícula nos cursos disponíveis na plataforma
    De maneira que –  o curso seja deletado permanentemente do sistema
<<<<<<< HEAD


=======
    
    
>>>>>>> ce21c7dc02117b822430e24805d93f0ab6fab6fa
**REQ09** - *Realizar matrícula*

    Como – usuário
    Eu quero –   realizar matrícula nos cursos disponíveis na plataforma
    De maneira que –  seja possível assistir as aulas, concluir as trilhas e receber o certificado de conclusão


**REQ10** - *Realizar Login*

    Como – usuário
    Eu quero –   realizar loginDTO na plataforma
    De maneira que –  – seja possível ter acesso a página principal da aplicação



> Imagine que fosse necessário enviar um email sempre que realizado o loginDTO, esse email deveria estar no fluxograma. Esse fluxograma pode ser mais simples, apenas com o objetivo de validar com o cliente que as dependências de negócio estão validadas em cada caso de negócio.

### Mensagens internas

Rotas utilizadas pela aplicação web para executar metodos de **POST** e **GET** no banco de dados. Onde o retorno de cada uma das funções estara contido em uma sessão para renderização de páginas web.

> Aqui ficam descritos os endpoints, que podem estar em outra documentação também.  
> É interessante colocar essa documentação aqui quando a API é pequena.

| Nome | Funcionalidade|
|------|--------------|
|```GET``` /listarUsuario|Informa todos usuários registrados no banco.|
|```POST``` /insereUsuario|Insere um novo usuário.|
|```PUT``` /atualizaUsuario|Atualiza o usuário.|

## Conceitos básicos
<<<<<<< HEAD
* [Design pattern](https://www.opus-software.com.br/design-patterns/) - Design Patterns ou padrões de projetos são soluções generalistas para problemas recorrentes durante o desenvolvimento de um software. Mais informações no [catalogo de design pattern](https://refactoring.guru/design-patterns). 
=======
* [Design pattern](https://www.opus-software.com.br/design-patterns/) - Design Patterns ou padrões de projetos são soluções generalistas para problemas recorrentes durante o desenvolvimento de um software. Mais informações no [catalogo de design pattern](https://refactoring.guru/design-patterns). 
>>>>>>> ce21c7dc02117b822430e24805d93f0ab6fab6fa
