package ru.cherepanov.test.task.dynamica.service.mapper;

import ru.cherepanov.test.task.dynamica.model.domain.Loan;
import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;
import ru.cherepanov.test.task.dynamica.model.response.ClientResponse;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;


public interface LoanMapper {

    Loan toEntity(TakeBookRequest takeBookRequest, ClientResponse clientResponse, BookResponse bookResponse);

    LoanResponse toResponse(Loan loan);
}
