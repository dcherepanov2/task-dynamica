package ru.cherepanov.test.task.dynamica.service.db;

import org.springframework.data.domain.Page;
import ru.cherepanov.test.task.dynamica.model.request.ClientEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.ClientSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.ClientResponse;

public interface DbClientService {

    ClientResponse findById(Long id);

    void save(ClientSaveRequest clientSaveRequest);

    void edit(ClientEditRequest clientEditRequest);

    Page<ClientResponse> findAll(int pageNumber);
}
