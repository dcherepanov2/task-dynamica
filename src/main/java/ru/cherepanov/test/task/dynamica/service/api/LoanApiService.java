package ru.cherepanov.test.task.dynamica.service.api;

import ru.cherepanov.test.task.dynamica.model.response.LoanResponse;

import java.util.List;

public interface LoanApiService {

    List<LoanResponse> findPage(int pageNumber);
}
