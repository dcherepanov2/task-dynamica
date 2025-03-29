package ru.cherepanov.test.task.dynamica.service.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.model.request.BookEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.BookSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;
import ru.cherepanov.test.task.dynamica.service.mapper.BookMapper;
import ru.cherepanov.test.task.dynamica.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DefaultDbBookService implements DbBookService {

    @Value("${db.find-all.books.limit}")
    private Integer findAllLimit;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public DefaultDbBookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Transactional
    @Override
    public Optional<BookResponse> findById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toResponse);
    }

    @Override
    public void save(BookSaveRequest bookSaveRequest) {
        Optional.ofNullable(bookSaveRequest)
                .map(bookMapper::toEntity)
                .ifPresent(bookRepository::save);
    }

    @Transactional
    @Override
    public void edit(BookEditRequest bookEditRequest) {
        Optional.ofNullable(bookEditRequest)
                .map(bookMapper::toEntity)
                .map(bookRepository::save);
    }

    @Transactional
    @Override
    public Page<BookResponse> findAll(int pageNumber) {
        return Optional.of(pageNumber)
                .map(pageNumberLocal -> PageRequest.of(pageNumber, findAllLimit))
                .map(bookRepository::findAll)
                .map(page -> page.map(bookMapper::toResponse))
                .orElse(Page.empty());
    }
}
