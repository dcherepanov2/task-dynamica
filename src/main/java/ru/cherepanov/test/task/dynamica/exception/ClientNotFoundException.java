package ru.cherepanov.test.task.dynamica.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long clientId) {
        super("Not found client with id: " + clientId);
    }
}
