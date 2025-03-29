package ru.cherepanov.test.task.dynamica.service.web;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;
import ru.cherepanov.test.task.dynamica.service.db.DbLoanService;

@Service
public class DefaultLoanWebService implements LoanWebService {

    private final DbLoanService dbLoanService;

    public DefaultLoanWebService(DbLoanService dbLoanService) {
        this.dbLoanService = dbLoanService;
    }

    @Override
    public void prepareLoanPage(Model model) {
        model.addAttribute("takeBook", new TakeBookRequest());
    }

    @Override
    public void takeBook(TakeBookRequest takeBookRequest, Model model) {
        dbLoanService.takeBook(takeBookRequest);
    }
}
