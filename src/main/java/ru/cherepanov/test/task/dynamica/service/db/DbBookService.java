package ru.cherepanov.test.task.dynamica.service.db;


import org.springframework.data.domain.Page;
import ru.cherepanov.test.task.dynamica.model.request.BookEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.BookSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;

public interface DbBookService {

    BookResponse findById(Long id);

    Page<BookResponse> findAll(int pageNumber);

    void save(BookSaveRequest bookSaveRequest);

    void edit(BookEditRequest bookEditRequest);
}
