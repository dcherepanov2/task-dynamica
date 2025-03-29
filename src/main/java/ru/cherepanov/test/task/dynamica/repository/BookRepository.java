package ru.cherepanov.test.task.dynamica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cherepanov.test.task.dynamica.model.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
