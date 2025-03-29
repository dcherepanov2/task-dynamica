package ru.cherepanov.test.task.dynamica.service.mapper;

import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.model.domain.Loan;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;

@Service
public class DefaultLoanMapper implements LoanMapper {

    @Override
    public LoanResponse toResponse(Loan loan) {
        LoanResponse loanResponse = new LoanResponse();
        loanResponse.setLoanDate(loan.getLoanDate());
        loanResponse.setBookIsbn(loan.getBook().getIsbn());
        loanResponse.setBookTitle(loan.getBook().getTitle());
        loanResponse.setReturnDate(loan.getReturnDate());
        loanResponse.setClientBirthDay(loan.getClient().getBirthDay());
        loanResponse.setClientFullName(loan.getClient().getFullName());
        return loanResponse;
    }
}
