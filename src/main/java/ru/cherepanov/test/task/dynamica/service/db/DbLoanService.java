package ru.cherepanov.test.task.dynamica.service.db;

import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;

import java.util.List;

public interface DbLoanService {

    void takeBook(TakeBookRequest takeBookRequest);

    List<LoanResponse> findPage(int pageNumber);
}
