package ru.cherepanov.test.task.dynamica.service.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.ui.Model;
import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;

public interface LoanWebService {

    void prepareLoanPage(Model model);

    void takeBook(TakeBookRequest takeBookRequest, Model model);
}
