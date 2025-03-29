package ru.cherepanov.test.task.dynamica.service.mapper;

import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.model.domain.Loan;
import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;
import ru.cherepanov.test.task.dynamica.model.response.ClientResponse;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;

@Service
public class DefaultLoanMapper implements LoanMapper{

    @Override
    public Loan toEntity(TakeBookRequest takeBookRequest, ClientResponse clientResponse, BookResponse bookResponse) {
        Loan loan = new Loan();
        loan.setBookId(bookResponse.getId());
        loan.setBookIsbn(bookResponse.getIsbn());
        loan.setBookTitle(bookResponse.getTitle());
        loan.setClientId(clientResponse.getId());
        loan.setClientBirthDay(clientResponse.getBirthDay());
        loan.setClientFullName(clientResponse.getFullName());
        return loan;
    }

    @Override
    public LoanResponse toResponse(Loan loan) {
        LoanResponse loanResponse = new LoanResponse();
        loanResponse.setLoanDate(loan.getLoanDate());
        loanResponse.setBookIsbn(loan.getBookIsbn());
        loanResponse.setBookTitle(loan.getBookTitle());
        loanResponse.setReturnDate(loan.getReturnDate());
        loanResponse.setClientBirthDay(loan.getClientBirthDay());
        loanResponse.setClientFullName(loan.getClientFullName());
        return loanResponse;
    }
}
