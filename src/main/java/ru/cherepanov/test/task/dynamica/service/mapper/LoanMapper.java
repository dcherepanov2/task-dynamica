package ru.cherepanov.test.task.dynamica.service.mapper;

import ru.cherepanov.test.task.dynamica.model.domain.Loan;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;


public interface LoanMapper {

    LoanResponse toResponse(Loan loan);
}
