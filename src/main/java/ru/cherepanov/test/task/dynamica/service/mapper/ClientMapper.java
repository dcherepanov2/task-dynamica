package ru.cherepanov.test.task.dynamica.service.mapper;

import ru.cherepanov.test.task.dynamica.model.domain.Client;
import ru.cherepanov.test.task.dynamica.model.request.ClientEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.ClientSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.ClientLoanResponse;
import ru.cherepanov.test.task.dynamica.model.response.ClientResponse;

public interface ClientMapper {

    ClientLoanResponse toLoanResponse(Client client);

    ClientResponse toResponse(Client client);

    Client toEntity(ClientEditRequest clientEditRequest);

    Client toEntity(ClientSaveRequest clientSaveRequest);
}
