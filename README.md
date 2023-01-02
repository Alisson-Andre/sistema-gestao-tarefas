# Sistema de Gestão de Tarefas - SIGTar

## Processo seletivo ESIG - Desenvolvedor Java

A aplicação consiste em um gerenciador de tarefas que possui as funcionalidades de criar, atualizar, remover, listar e filtrar tarefas por diferentes campos. A aplicação foi desenvolvida na IDE Eclipse utilizando as tecnologias Java, JSF, Primefaces, JPA/Hibernate e CDI, a persistência em banco de dados PostegreSQL, as dependências gerenciadas pelo Maven e o WildFly como servidor.

#### Cadastro
![cadastrarTarefa](https://user-images.githubusercontent.com/103791966/210238684-ba8c5426-620e-4f93-8833-bc5240eb91a1.png)

#### Listagem
![ListaTarefa](https://user-images.githubusercontent.com/103791966/210239772-28501935-3a3d-46ae-809c-1187e71ca5d3.png)

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
