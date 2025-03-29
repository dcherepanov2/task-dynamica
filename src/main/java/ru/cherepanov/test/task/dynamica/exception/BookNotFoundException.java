package ru.cherepanov.test.task.dynamica.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long bookId) {
        super("Not found book with id: " + bookId);
    }
}
