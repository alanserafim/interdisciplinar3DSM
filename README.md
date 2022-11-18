# [Fatecflix - Plataforma de cursos online da Fatec Zona Leste](https://alanserafim.github.io/fatecflix-angular/home)

## Projeto Interdisciplinar

### Curso: 
* Desenvolvimento de Software Multiplaforma da Fatec Zona Leste (3º Semestre)

### Disciplinas: 
* Desenvolvimento Web III
* Interação Humano Computador 
* Banco de Dados Não Relacional. 


<fig>
<img src="https://rockcontent.com/br/wp-content/uploads/sites/2/elementor/thumbs/modelo-de-projeto-p2he6clp7uhmwqd16ikv9jgz30a5liixoon908hej0.png" alt="Uma imagem relacionada ao projeto">
</fig>


## Inicialização
Para executar o projeto, utilize as ferramentas descritas na sessão *Ferramentas*.

## Ferramentas
* Spring Boot - Spring Tools for Eclipse IDE (https://spring.io/projects/spring-boot) - IDE para desenvolvimento.
* Visual Studio Code (https://code.visualstudio.com/docs) - Editor de código utilizado na camada cliente.

## Links importantes
* [Spring Boot Rest API](https://medium.com/better-programming/building-a-spring-boot-rest-api-a-php-developers-view-part-i-6add2e794646) -  API com Spring Boot - Framework da camada servidor.

* [Angular Framework](https://angular.io/) - Framework da camada cliente.

# [FatecFlix](https://alanserafim.github.io/fatecflix-angular/home)

## Introdução

Este projeto possui o objetivo principal **implementar uma plataforma de cursos online da Fatec Zona Leste**.  

Com os objetivos gerais de gerenciamento cursos voltados para os alunos dos cursos de graduação.


## Análise técnica

### Descrição do ambiente técnico

O sistema é composto por uma API REST e um banco de dados relacional na camada servidor; uma interface web na camada cliente. Funcionalidades principais:

* **F1** - Controle de usuários.
* **F2** - Controle de cursos.
* **F3** - Controle de aulas.
* **F4** - Controle de exercícios.
* **F5** - Controle de matriculas.

As ferramentas utilizadas para o desenvolvimento incluem **Java** que é uma linguagem de programação utilizada para o Back-end, para front-end foi utilizado **TypeScript, HTML5, CSS**. Com **MySQL** atuando como sistema gerenciador de banco de dados relacional.

### Requisitos Funcionais
Respeitando a proposta, o sistema deverá atender os seguintes requisitos:

* **RF1** - O usuário deve poder realizar as operações de cadastro, consulta, alteração e exclusão de seus dados.
* **RF2** - O instrutor deve poder cadastrar, consultar, alterar ou excluir cursos.
* **RF3** - O usuário deve poder se matricular, cancelar matrícula e acompanhar seu progresso nos cursos disponíveis.

## Regras de Negócio

**RGN1** -  O cliente só fará a solicitação se estiver cadastrado e logado.

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

**REQ04** - *Excluir perfil*

    Como – usuário
    Eu quero –  excluir o meu perfil
    De maneira que – os dados sejam deletados permanentemente do sistema

**REQ05** - *Cadastrar curso*

    Como – instrutor
    Eu quero –  criar um curso
    De maneira que –  seja possível para outros usuários matricularem-se e visualizar a trilha do curso

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

**REQ09** - *Realizar matrícula*

    Como – usuário
    Eu quero –   realizar matrícula nos cursos disponíveis na plataforma
    De maneira que –  seja possível assistir as aulas, concluir as trilhas e receber o certificado de conclusão


**REQ10** - *Realizar Login*

    Como – usuário
    Eu quero –   realizar login na plataforma
    De maneira que –  – seja possível ter acesso a página principal da aplicação


### Diagrama de Classes de Domínio

* Inserir imagem do diagrama

### Wireframe

* Inserir imagem do wireframe

### Links do Projeto

* Documentação da API Rest (https://fatecflix.herokuapp.com/swagger-ui.html)
* Interface Web (https://alanserafim.github.io/fatecflix-angular/home)

### Mensagens internas

Rotas utilizadas pela aplicação web para executar metodos de **POST** e **GET** no banco de dados. Onde o retorno de cada uma das funções estara contido em uma sessão para renderização de páginas web.

* [SWAGGER](https://fatecflix.herokuapp.com/swagger-ui.html)

## Conceitos básicos

##### Processo de Desenvolvimento de Software - PDS

> O PDS segue uma abordagem interativa incremental adaptada do Processo Unificado (Larman, 2006 - cap02). Cada atividade da interação tem uma definição de pronto estabelecida com objetivo de controlar a qualidade. 

![ciclo de desenvolvimento up](https://user-images.githubusercontent.com/68782201/180198367-01b275f2-1bf1-409c-a7b7-46f231e4ff6e.png) 

* 1 - Concepção – visão aproximada, casos de uso de negócio, escopo e estimativas vagas (fase de estudo de viabilidade) 
* 2 - Elaboração – visão refinada, a arquitetura central é iterativamente implementada e os problemas de alto risco são mitigados, identificação da maioria dos requisitos e do escopo e estimativas mais realistas. 
O projeto de software é iniciado logo que os requisitos de software tenham sido analisados e modelados e prepara a equipe para a transição entre a análise e o código. O projeto arquitetural define os relacionamentos entre os principais 
elementos estruturais do software (PRESSMAN, 6ed. p. 187). O projeto arquitetural pode ser apresentado na forma de múltiplas perspectivas. Krutchen (1995) sugere 4 visões: visão lógica, visão de implementação, visão de processo e visão de 
instalação. Adicionalmente as 4 visões existe os cenários que determinam a dinâmica e o comportamento da aplicação. Cada cenário descreve como os vários componentes arquiteturais colaboram para manipular uma operação de sistema. 
* 3 - Construção – mapeamento do projeto para o código, implementação iterativa dos elementos restantes de menor risco e preparação para implantação. No início da interação a equipe se reúne para garantir que existe um entendimento comum 
entre os envolvidos sobre o comportamento do software. Esta atividade será considerada concluída quando os exemplos de uso são discutidos e existe um "de acordo" no entendimento. Os requisitos serão documentados utilizando "estórias de 
usuário". Os requisitos serão priorizados (alto, médio ou baixo) de acordo com a complexidade para o desenvolvimento (funções mais complexas são mais sujeitas a falhas) e o perfil operacional de uso (funções mais utilizadas tem um impacto 
alto na falha). Exemplos de uso da aplicação servem como base na especificação dos casos de teste. 
* 4 - Transição – beta testes e implantação 

> A definição de "pronto" estabelece como a qualidade será atingida 

| Fase | Definição de pronto estabelecida para cada fase - critério de aceitação | 
| ------------ | ------------------------------------------------------------------------ | 
| Concepção | Uma análise de viabilidade técnica e econômica é realizada para apoiar a tomada de decisão continua ou declina do projeto | 
| Elaboração | Esta atividade será considerada concluída quando o Diagrama de Classes de Domínio (DCD) (LARMAN, 2006) e um esboço da visão lógica da arquitetura (KRUTCHEN, 2005) for definido e uma análise de rastreabilidade entre o DCD e o documento de requisitos não identificarem inconsistências | 
| Codificação |Será considerada concluída quando a análise de rastreabilidade entre o código e as funções solicitadas no documento de requisitos não identificarem inconsistências | 
| Teste | Será considerada concluída quando 100% dos casos de teste prioritários (complexidade, funções mais utilizadas) rastreáveis para os requisitos obtiverem satisfatório | 


>Referencias 
- [1] KRUCHTEN, Philippe. Reference: Title: Architectural blueprints—the “4+ 1” view model of software architecture. IEEE software, v. 12, n. 6, 1995. 
- [2] RICHARDSON, Chris. Microservices patterns: with examples in Java. Simon and Schuster, 2018. 
- [3] ERL, Thomas. SOA principles of service design (the Prentice Hall service-oriented computing series from Thomas Erl). Prentice Hall PTR, 2007. 
- [4] LARMAN, Craig. Utilizando UML e padrões. 2aed., Porto Alegre: Bookman Editora, 2006.

