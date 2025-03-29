package ru.cherepanov.test.task.dynamica.service.api;

import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;
import ru.cherepanov.test.task.dynamica.service.db.DbLoanService;

import java.util.List;

@Service
public class DefaultLoanApiService implements LoanApiService {

    private final DbLoanService dbLoanService;

    public DefaultLoanApiService(DbLoanService dbLoanService) {
        this.dbLoanService = dbLoanService;
    }

    @Override
    public List<LoanResponse> findPage(int pageNumber) {
        return dbLoanService.findPage(pageNumber);
    }
}
