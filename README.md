# Albuquerque 's Library System (en)

Welcome to the **Albuquerque 's Library System**! This project is a library management tool that allows for managing books, members, authors, and loans. The system helps to track the status of book loans, apply fines for late returns, and manage the members and authors associated with the library.

## Features

- **Manage Members**: Add, update, search members of the library.
- **Manage Authors**: Add, update, search authors, associate author to a book of the library.
- **Manage Books**: Add new books to the collection, associate books with authors.
- **Loan Management**: Keep track of active loans, return books, calculate late fees, and update loan status.
- **Fines Calculation**: Automatically calculate late fees for overdue books based on the return date.
- **Reporting**: Generate reports on members, loans, and books.
- **Error Handling**: Custom exceptions for managing application and database errors.

## Tech Stack

- **Java**: Main programming language used for business logic and system development.
- **Maven**: For managing dependencies and building the project.

## Fine Calculation Logic

- The system calculates fines for overdue books at a rate of **5.0 per day**.
- The loan period is set to **5 days**.
- Fines are applied automatically when the book is returned after the due date.

### Example:
```java
if (now.isAfter(dueDate)) {
    Duration duration = Duration.between(test1.atTime(0,0), now2.atTime(0,0));

    long daysLate = duration.toDays();
    System.out.println("Days late: " + daysLate);

    double fine = daysLate * 5.0;
    loan.setFine(fine);
    loan.setStateLoan(StateLoan.LATE);
    loanDAO.update(loan);
}
```

## Getting Started

### Installation

1. Clone the repository:
```bash
   git clone https://github.com/VitorSAlb/SP_SpringBoot_AWS_Desafio_01.git
```
2. Navigate to the project directory:
```bash
   cd SP_SpringBoot_AWS_Desafio_01/library
```

### Create a database "library" 
   
1. Access the mysql terminal through the workbench 

2. Create a database "library" 
```bash
CREATE DATABASE Library;
```

NOTE: The tables will be created automatically when you start the project.

#### Run project with cmd

1. Install dependencies and build the project:
   ```bash
   mvn clean install
   ```

2. Run the project:
   ```bash
   mvn exec:java
   ```

#### Run Project with IDE

Access the project with your preferred IDE, install the Maven dependencies and run the project!

# Sistema de Biblioteca de Albuquerque (pt-br)

Bem-vindo ao **Sistema de Biblioteca de Albuquerque**! Este projeto é uma ferramenta de gerenciamento de biblioteca que permite gerenciar livros, membros, autores e empréstimos. O sistema ajuda a rastrear o status de empréstimos de livros, aplicar multas por devoluções atrasadas e gerenciar os membros e autores associados à biblioteca.

## Recursos

- **Gerenciar membros**: adicionar, atualizar, pesquisar membros da biblioteca.
- **Gerenciar autores**: adicionar, atualizar, pesquisar autores, associar autor a um livro da biblioteca.
- **Gerenciar livros**: adicionar novos livros à coleção, associar livros a autores.
- **Gerenciamento de empréstimos**: acompanhar empréstimos ativos, devolver livros, calcular taxas de atraso e atualizar o status do empréstimo.
- **Cálculo de multas**: calcular automaticamente taxas de atraso para livros atrasados ​​com base na data de devolução.
- **Relatórios**: gerar relatórios sobre membros, empréstimos e livros.
- **Tratamento de erros**: exceções personalizadas para gerenciar erros de aplicativo e banco de dados.

## Pilha de tecnologia

- **Java**: Linguagem de programação principal usada para lógica de negócios e desenvolvimento de sistemas.
- **Maven**: Para gerenciar dependências e construir o projeto.

## Lógica de cálculo de multas

- O sistema calcula multas para livros atrasados ​​a uma taxa de **5,0 por dia**.
- O período de empréstimo é definido como **5 dias**.
- As multas são aplicadas automaticamente quando o livro é devolvido após a data de vencimento.

### Exemplo:
```java
if (now.isAfter(dueDate)) {
Duration duration = Duration.between(test1.atTime(0,0), now2.atTime(0,0));

long daysLate = duration.toDays();
System.out.println("Dias de atraso: " + daysLate);

double fine = daysLate * 5.0;
loan.setFine(fine);
loan.setStateLoan(StateLoan.LATE);
loanDAO.update(loan);
}
```

## Primeiros passos

### Instalação

1. Clone o repositório:
```bash
git clone https://github.com/VitorSAlb/SP_SpringBoot_AWS_Desafio_01.git
```
2. Navegue até o diretório do projeto:
```bash
cd SP_SpringBoot_AWS_Desafio_01/library
```
### Crie a database "library"

1. Acesse o terminal do mysql pelo workbanch

2. Crie a database "library"
```bash
CREATE DATABASE Library;
´´´

OBS: As tabelas serão criadas automaticamente quando iniciar o projeto.

#### Execute o projeto com cmd

1. Instale as dependências e compile o projeto:
```bash
mvn clean install
```

2. Execute o projeto:
```bash
mvn exec:java
```

#### Execute o projeto com IDE

Acesse o projeto com seu IDE preferida, instale as dependências do Maven e execute o projeto!