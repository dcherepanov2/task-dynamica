package ru.cherepanov.test.task.dynamica.service.mapper;

import ru.cherepanov.test.task.dynamica.model.domain.Book;
import ru.cherepanov.test.task.dynamica.model.request.BookEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.BookSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookLoanResponse;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;

public interface BookMapper {

    BookLoanResponse toLoanResponse(BookResponse bookResponse);

    Book toEntity(BookSaveRequest bookSaveRequest);

    Book toEntity(BookEditRequest bookEditRequest);

    BookResponse toResponse(Book book);
}
