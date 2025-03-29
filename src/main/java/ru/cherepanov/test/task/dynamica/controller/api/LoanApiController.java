package ru.cherepanov.test.task.dynamica.controller.api;

import org.springframework.web.bind.annotation.*;
import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;
import ru.cherepanov.test.task.dynamica.service.api.LoanApiService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanApiController {

    private final LoanApiService loanApiService;

    public LoanApiController(LoanApiService loanApiService) {
        this.loanApiService = loanApiService;
    }

    @GetMapping("/find-page")
    public List<LoanResponse> findPage(@RequestParam("pageNumber") Integer pageNumber){
        return loanApiService.findPage(pageNumber);
    }
}
