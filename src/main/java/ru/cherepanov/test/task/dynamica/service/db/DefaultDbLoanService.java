package ru.cherepanov.test.task.dynamica.service.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.model.domain.Book;
import ru.cherepanov.test.task.dynamica.model.domain.Client;
import ru.cherepanov.test.task.dynamica.model.domain.Loan;
import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;
import ru.cherepanov.test.task.dynamica.repository.BookRepository;
import ru.cherepanov.test.task.dynamica.repository.ClientRepository;
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
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;
    private final LoanMapper loanMapper;
    private final LoanRepository loanRepository;

    public DefaultDbLoanService(
            BookRepository bookRepository,
            ClientRepository clientRepository,
            LoanMapper loanMapper,
            LoanRepository loanRepository
    ) {
        this.bookRepository = bookRepository;
        this.clientRepository = clientRepository;
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    @Transactional
    @Override
    public void takeBook(TakeBookRequest takeBookRequest) {
        Optional.of(takeBookRequest)
                .map(this::createWithAttachBookAndClient)
                .ifPresent(loanRepository::save);
    }

    @Override
    public List<LoanResponse> findPage(int pageNumber) {
        return Optional.of(pageNumber)
                .map(pageNumberLocal -> PageRequest.of(pageNumber, findAllLimit))
                .map(loanRepository::findPageWithClientAndBook)
                .map(page -> page.map(loanMapper::toResponse))
                .map(Streamable::get)
                .map(loans -> loans.collect(Collectors.toList()))
                .orElseThrow(IllegalStateException::new);
    }

    private Loan createWithAttachBookAndClient(TakeBookRequest takeBookRequest) {
        Book book = bookRepository.getReferenceById(takeBookRequest.getBookId());
        Client client= clientRepository.getReferenceById(takeBookRequest.getClientId());

        Loan loan = new Loan();
        loan.setClient(client);
        loan.setBook(book);

        return loan;
    }
}
