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

-- денормализовал для скорости работы
-- подразамивалась, что будет таска, которая будет раз в n время обновлять записи для
-- отбражения актуальных и консистентных данных
CREATE TABLE IF NOT EXISTS library.loans (
    id SERIAL PRIMARY KEY,
    book_id INTEGER NOT NULL,
    client_id INTEGER NOT NULL,
    client_full_name VARCHAR(255) NOT NULL,
    client_birth_day DATE NOT NULL,
    book_title VARCHAR(255) NOT NULL,
    book_isbn VARCHAR(255) NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE
);

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS book_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS loan_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS client_seq START WITH 1 INCREMENT BY 1;
