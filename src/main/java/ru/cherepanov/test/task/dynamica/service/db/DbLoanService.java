package ru.cherepanov.test.task.dynamica.service.db;

import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;

import javax.transaction.Transactional;
import java.util.List;

public interface DbLoanService {

    void takeBook(TakeBookRequest takeBookRequest);

    @Transactional
    List<LoanResponse> findAll(int pageNumber);
}
