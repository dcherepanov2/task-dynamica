package ru.cherepanov.test.task.dynamica.service.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.exception.BookNotFoundException;
import ru.cherepanov.test.task.dynamica.exception.ClientNotFoundException;
import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;
import ru.cherepanov.test.task.dynamica.model.response.ClientResponse;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;
import ru.cherepanov.test.task.dynamica.repository.LoanRepository;
import ru.cherepanov.test.task.dynamica.service.mapper.LoanMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultDbLoanService implements DbLoanService {

    @Value("${db.find-all.loan.limit}")
    private int findAllLimit;
    private final DbBookService dbBookService;
    private final DbClientService dbClientService;
    private final LoanMapper loanMapper;
    private final LoanRepository loanRepository;

    public DefaultDbLoanService(
            DbBookService dbBookService,
            DbClientService dbClientService,
            LoanMapper loanMapper,
            LoanRepository loanRepository
    ) {
        this.dbBookService = dbBookService;
        this.dbClientService = dbClientService;
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    @Transactional
    @Override
    public void takeBook(TakeBookRequest takeBookRequest) {
        BookResponse bookResponse = Optional.of(takeBookRequest)
                .map(TakeBookRequest::getBookId)
                .flatMap(dbBookService::findById)
                .orElseThrow(() -> new BookNotFoundException(takeBookRequest.getBookId()));

        ClientResponse clientResponse = Optional.of(takeBookRequest)
                .map(TakeBookRequest::getClientId)
                .flatMap(dbClientService::findById)
                .orElseThrow(() -> new ClientNotFoundException(takeBookRequest.getClientId()));

        Optional.of(takeBookRequest)
                .map(takeBookRequestLocal ->
                        loanMapper.toEntity(takeBookRequest, clientResponse, bookResponse))
                .ifPresent(loanRepository::save);
    }

    @Transactional
    @Override
    public List<LoanResponse> findAll(int pageNumber) {
        return Optional.of(pageNumber)
                .map(pageNumberLocal -> PageRequest.of(pageNumber, findAllLimit))
                .map(loanRepository::findAll)
                .map(page -> page.map(loanMapper::toResponse))
                .map(Streamable::get)
                .map(loans -> loans.collect(Collectors.toList()))
                .orElseThrow(IllegalStateException::new);
    }
}
