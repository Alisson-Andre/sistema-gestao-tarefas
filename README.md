# Sistema de Gestão de Tarefas - SIGTar

## Processo seletivo ESIG - Desenvolvedor Java

A aplicação consiste em um gerenciador de tarefas que possui as funcionalidades de criar, atualizar, remover, listar e filtrar tarefas por diferentes campos. A aplicação foi desenvolvida na IDE Eclipse utilizando as tecnologias Java, JSF, Primefaces, JPA/Hibernate e CDI, a persistência em banco de dados PostegreSQL, as dependências gerenciadas pelo Maven e o WildFly como servidor.

#### Cadastro/Edição
![cadastrarTarefa](https://user-images.githubusercontent.com/103791966/210242563-e248edcc-b634-4afb-b9e6-fc7be14aa531.png)

#### Listagem
![ListaTarefa](https://user-images.githubusercontent.com/103791966/210242633-54a67e4e-62f8-4650-8bd3-801f3c36b2cd.png)

### Instruções para execução em um ambiente local
- Baixe o repositório (https://github.com/Alisson-Andre/sistema-gestao-tarefas.git);
- Abra o projeto no Eclipse;
- Crie o banco de dados com o nome “db_tarefas”, usuário “postgres” e senha “0123456” ou altere a URL, User e Password  no arquivo persistence.xml conforme está configurado seu banco de dados;
- Execute o servidor;
- Acesse a página em: http://localhost:8080/sistema-gestao-tarefas/index.xhtml 

### Tecnologias

- Java 8
- JavaEE 7
- JSF 2.2
- Primefaces v12
- PostgreSQL 12
- WildFly 26.1.2.Final
- Eclipse IDE 2022
