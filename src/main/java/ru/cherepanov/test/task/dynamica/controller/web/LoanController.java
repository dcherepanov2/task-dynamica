package ru.cherepanov.test.task.dynamica.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cherepanov.test.task.dynamica.model.WebResult;
import ru.cherepanov.test.task.dynamica.model.request.TakeBookRequest;
import ru.cherepanov.test.task.dynamica.service.web.LoanWebService;

@Controller
@RequestMapping("/take-book")
public class LoanController {

    private final LoanWebService loanWebService;

    public LoanController(LoanWebService loanWebService) {
        this.loanWebService = loanWebService;
    }

    @GetMapping
    public String prepareTakeBook(Model model) {
        return WebResult.withoutValid()
                .onSuccessVoid(() -> loanWebService.prepareLoanPage(model))
                .fold(() -> "loans/take-book");
    }

    @PostMapping
    public String takeBook(@ModelAttribute TakeBookRequest takeBookRequest, Model model) {
        return WebResult.withoutValid()
                .onSuccessVoid(() -> loanWebService.takeBook(takeBookRequest, model))
                .fold(() -> "loans/take-book");
    }
}
