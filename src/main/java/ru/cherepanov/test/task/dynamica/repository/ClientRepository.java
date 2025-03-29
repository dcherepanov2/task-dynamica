package ru.cherepanov.test.task.dynamica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cherepanov.test.task.dynamica.model.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
