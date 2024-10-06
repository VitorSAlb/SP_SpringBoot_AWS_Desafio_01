# Albuquerque 's Library System

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