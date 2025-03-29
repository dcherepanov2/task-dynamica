package ru.cherepanov.test.task.dynamica.service.db;


import org.springframework.data.domain.Page;
import ru.cherepanov.test.task.dynamica.model.request.BookEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.BookSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;

import java.util.Optional;

public interface DbBookService {

    Optional<BookResponse> findById(Long id);

    void save(BookSaveRequest bookSaveRequest);

    void edit(BookEditRequest bookEditRequest);

    Page<BookResponse> findAll(int pageNumber);
}
