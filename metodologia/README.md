# Davi Soares

## Introdução

Olá! Me chamo [Davi Soares](https://davisoares.com.br/), tenho 20 anos, e estou cursando Banco de Dados na Fatec SJC.

Sou um entusiasta de carros, apreciador da boa música e da culinária italiana. Gosto de solucionar problemas, de códigos organizados, gosto de acompanhar tendências e de aprender coisas novas.

Trabalho atualmente como **desenvolvedor fullstack** na [IACIT](https://iacit.com.br/), onde tenho a oportunidade de aplicar meus conhecimentos em Java, Spring Boot, React e PostgreSQL.

<div align = center>
    <img src="https://avatars.githubusercontent.com/u/94925054?v=4" alt="Davi Soares" width="200" height="200">
</div>
<div align = center>
    <a href="https://www.linkedin.com/in/dsf21/" target="_blank">
        <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank" alt="Meu Linkedin">
    </a>
    <a href="mailto:davisfs2110@gmail.com">
        <img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" target="_blank" alt="E-mail">
    </a>
    <a href="https://github.com/DaviSFS21" target="_blank">
        <img src="https://img.shields.io/badge/github-000000?style=for-the-badge&logo=github" target="_blank" alt="Meu Github">
    </a>
</div>
<br>

## Meus Principais Conhecimentos
Apresente seus principais conhecimentos. Foque nos conhecimentos que possui maior domínio e que deseja desenvolver durante sua carreira.

## Meus Projetos

## Em 2024-1

---

### *Projeto: Calculadora Científica*
Projeto desenvolvido com a [sqlutions](https://github.com/SQLutions-FATEC) para o cliente interno da Fatec.

O problema apresentado pelo cliente foi a necessidade de uma calculadora científica, que fosse leve e simples de ser utilizada.

A solução entregue foi uma aplicação executável que permite ao usuário realizar cálculos científicos de forma rápida e eficiente, diretamente no terminal.

[Calculadora Científica - 1º Semestre](https://github.com/SQLutions-FATEC/API-1-Semestre)

// TODO: continue the portfolio
#### Tecnologias Utilizadas
Apresente brevemente as tecnologias utilizadas. Uma tecnologia por linha. Indique qual a importância de cada tecnologia para o projeto.

#### Contribuições Pessoais
Apresente suas contribuições no projeto. Foque nas funcionalidades em que você mais atuou. Descreva sua atuação em detalhes, especificando que tecnologias você utilizou.

#### Hard Skills
Apresente as hard skills que você utilizou/desenvolveu durante o projeto e o nível de proficiência alcançado. Exemplo: CSS - Sei fazer com autonomia

#### Soft Skills
Apresente as soft skills que você utilizou/desenvolveu durante o projeto e em quais situações elas foram fundamentais. Exemplo: Comunicação - Precisei exercitar minhas habilidades de comunicação para viabilizar as reuniões semanais levando em conta as disponibilidades dos membros, que não cursavam as mesmas disciplinas.

---

### Em 2024-2
Projeto desenvolvido com a [sqlutions](https://github.com/SQLutions-FATEC) para o cliente interno da Fatec.

O problema trazido pelo cliente foi a necessidade de padronização do processo de avaliação de alguns aspectos dos membros de uma equipe da API da Fatec, ao final de cada sprint.

A solução desenvolvida foi uma aplicação feita em java, utilizando JavaFX para a interface. A aplicação também permite gerar relatórios em Excel partindo do banco de dados da aplicação, facilitando a utilização dos resultados pelo professor.

[Avaliador PACER - 2º Semestre](https://github.com/SQLutions-FATEC/API-2-Semestre)

---

### Em 2025-1&nbsp;&nbsp;&nbsp;<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/> &nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vuejs/vuejs-original.svg" width="40" height="40"/> &nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" width="40" height="40"/> &nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-original.svg" width="40" height="40"/> &nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-plain.svg" width="40" height="40"/>
Projeto desenvolvido com a [sqlutions](https://github.com/SQLutions-FATEC) para a empresa cliente [ALTAVE](https://altave.com.br/).

O cliente nos trouxe a necessidade de monitoramento dos horários cumpridos pelos funcionários de empresas terceiras que atuam na manutenção de navios. Devido aos custos milionários de operação desses veículos, é necessário assegurar que todos os contratos estão sendo corretamente cumpridos.

A solução desenvolvida foi uma aplicação web com backend em Java e frontend em Vue.js. O projeto entregue fornece a visualização de dashboards e tabelas, todas referentes aos dados de entrada e saída dos usuários, além do período em que estiveram presentes no local. Além de uma API (Application Programming Interface) que não precisa ser estritamente consumida pelo front desenvolvido para o cliente.

[Checkpoint - 3º Semestre](https://github.com/SQLutions-FATEC/API-3-Semestre)

#### Tecnologias Utilizadas

***Java Spring Boot:*** O principal pilar para o desenvolvimento do backend é o Java com framework Spring, que agiliza o desenvolvimento e fornece uma base sólida para a criação de uma API.

***Vue.js:*** Muito presente no mercado, o framework Vue.js permite a componentização, que favorece a reutilização de código em diferentes partes do código. Com ele, elementos como formulários e botões são facilmente padronizados, trazendo elegância ao código e robustez no desenvolvimento.

***PostgreSQL:***  O banco de dados relacional PostgreSQL foi escolhido por sua robustez, escalabilidade e suporte a operações complexas. Ele é ideal para armazenar e gerenciar os dados estruturados do sistema, garantindo integridade e desempenho. Foi ideal para fornecer as métricas que alimentam a dashboard.

***Docker:*** A utilização do Docker no projeto facilitou a configuração e o gerenciamento dos ambientes de desenvolvimento e produção. Com contêineres, conseguimos garantir que a aplicação funcione de maneira consistente em diferentes máquinas, simplificando o processo de implantação e reduzindo problemas relacionados a dependências e configurações.

#### Contribuições Pessoais

<details> 
<summary>
<b>Conteinerização do banco de dados:</b>
Estruturei a conteinerização do banco com Docker (builds multi-stage, variáveis de ambiente e volumes), padronizando o setup de desenvolvimento e produção com documentação de uso.
</summary>

> ***Utilização de imagem do PostgreSQL***
>
> Como contribuição para o desenvolvimento padronizado da aplicação, procurei entender e estudar a ferramenta Docker para a implementação no fluxo de desenvolvimento do nosso trabalho.
>
> ```yaml
> services:
>   db:
>     image: postgres:16
>     container_name: sqlutions-db
>     ports:
>       - "5432:5432"
>     environment:
>       POSTGRES_USER: user
>       POSTGRES_PASSWORD: admin
>       POSTGRES_DB: sistema-de-ponto
>     volumes:
>       - postgres_data:/var/lib/postgresql/data
> 
> volumes:
>   postgres_data:
> ```
</details>

<details> 
<summary>
<b>Queries :</b>
Implementei no backend os endpoints de registro/consulta de ponto e relatórios, com paginação e filtros, mapeamentos JPA, validações e tratamento de erros e otimizei consultas no PostgreSQL para alimentar corretamente os dashboards.
</summary>

> ***Utilização de imagem do PostgreSQL***
>
> Como contribuição para o desenvolvimento padronizado da aplicação, procurei entender e estudar a ferramenta Docker para a implementação no fluxo de desenvolvimento do nosso trabalho.
>
> ```yaml
> services:
>   db:
>     image: postgres:16
>     container_name: sqlutions-db
>     ports:
>       - "5432:5432"
>     environment:
>       POSTGRES_USER: user
>       POSTGRES_PASSWORD: admin
>       POSTGRES_DB: sistema-de-ponto
>     volumes:
>       - postgres_data:/var/lib/postgresql/data
> 
> volumes:
>   postgres_data:
> ```
</details>

#### Hard Skills

***Implementação de imagens com Docker:*** Desenvolvi a configuração dos contêineres Docker para o ambiente de desenvolvimento e produção, garantindo que a aplicação pudesse ser facilmente implantada em diferentes ambientes sem problemas de compatibilidade.

***Implementação do Spring Boot:*** Atuei no desenvolvimento de diversas funcionalidades do backend utilizando o framework Spring Boot, incluindo a criação de endpoints RESTful, integração com o banco de dados PostgreSQL e implementação de lógica de negócios.

***Familiaridade com Git:*** Ao resolver conflitos, revisar PRs e gerenciar as branches, desenvolvi mais habilidade na utilização do terminal e no versionamento das diversas frentes do projeto.

#### Soft Skills

***Comunicação com o cliente:*** Durante o período em que o produto foi desenvolvido, pude exercitar minhas habilidades de comunicação, garantindo conversações assertivas num cenário onde o cliente não está sempre presente. Busquei elaborar perguntas claras e pertinentes, facilitando o entendimento das necessidades do cliente e a transmissão das informações para a equipe.

***Gerenciamento de projeto:*** Manter a equipe ativa e motivada foi um desafio superado com demandas claras e uma estratégia que garantia uma entrega de valor ao fim da sprint. A organização das tarefas e o acompanhamento do progresso foram essenciais para o sucesso do projeto.

***Apresentação de produto:*** O momento de apresentar o produto para o cliente foi uma oportunidade de grande desenvolvimento profissional e pessoal, mesmo em ambiente acadêmico. Garantir a satisfação do cliente, apesar dos imprevistos inevitáveis no desenvolvimento de software é, sem dúvidas, a experiência mais relevante que levarei da Fatec.

### Em 2025-2
Mesmo formato

### Em 2026-1
Mesmo formato

### Em 2026-2
Mesmo formato
