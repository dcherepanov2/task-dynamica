-- использовал бы flyway/liquebase если бы она была указана в стеке технологий к тех заданию
CREATE SCHEMA IF NOT EXISTS library;

CREATE TABLE IF NOT EXISTS library.books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) NOT NULL
);

CREATE TABLE IF NOT EXISTS library.clients (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    birth_day DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS library.loans (
    id SERIAL PRIMARY KEY,
    book_id INTEGER NOT NULL,
    client_id INTEGER NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE
);

CREATE INDEX IF NOT EXISTS idx_loans_book_id ON library.loans(book_id);
CREATE INDEX IF NOT EXISTS idx_loans_client_id ON library.loans(client_id);

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS book_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS loan_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS client_seq START WITH 1 INCREMENT BY 1;
