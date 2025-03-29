package ru.cherepanov.test.task.dynamica.service.mapper;

import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.model.domain.Book;
import ru.cherepanov.test.task.dynamica.model.request.BookEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.BookSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookLoanResponse;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;

@Service
public class DefaultBookMapper implements BookMapper {

    @Override
    public BookLoanResponse toLoanResponse(BookResponse bookResponse) {
        BookLoanResponse bookLoanResponse = new BookLoanResponse();
        bookLoanResponse.setAuthor(bookResponse.getAuthor());
        bookLoanResponse.setIsbn(bookResponse.getIsbn());
        bookLoanResponse.setTitle(bookResponse.getTitle());
        return bookLoanResponse;
    }

    @Override
    public Book toEntity(BookSaveRequest bookSaveRequest) {
        Book book = new Book();
        book.setAuthor(bookSaveRequest.getAuthor());
        book.setIsbn(bookSaveRequest.getIsbn());
        book.setTitle(bookSaveRequest.getTitle());
        return book;
    }

    @Override
    public Book toEntity(BookEditRequest bookEditRequest) {
        Book book = new Book();
        book.setId(bookEditRequest.getId());
        book.setAuthor(bookEditRequest.getAuthor());
        book.setIsbn(bookEditRequest.getIsbn());
        book.setTitle(bookEditRequest.getTitle());
        return book;
    }

    @Override
    public BookResponse toResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setIsbn(book.getIsbn());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setId(book.getId());
        return bookResponse;
    }
}
