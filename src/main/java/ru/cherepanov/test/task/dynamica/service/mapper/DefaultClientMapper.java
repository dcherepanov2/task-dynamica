package ru.cherepanov.test.task.dynamica.service.mapper;

import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.model.domain.Client;
import ru.cherepanov.test.task.dynamica.model.request.ClientEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.ClientSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.ClientLoanResponse;
import ru.cherepanov.test.task.dynamica.model.response.ClientResponse;

@Service
public class DefaultClientMapper implements ClientMapper {

    @Override
    public ClientLoanResponse toLoanResponse(Client client) {
        ClientLoanResponse clientLoanResponse = new ClientLoanResponse();
        clientLoanResponse.setBirthDay(client.getBirthDay());
        clientLoanResponse.setFullName(client.getFullName());
        return clientLoanResponse;
    }

    @Override
    public ClientResponse toResponse(Client client) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setId(client.getId());
        clientResponse.setBirthDay(client.getBirthDay());
        clientResponse.setFullName(client.getFullName());
        return clientResponse;
    }

    @Override
    public Client toEntity(ClientEditRequest clientEditRequest) {
        Client client = new Client();
        client.setId(clientEditRequest.getId());
        client.setBirthDay(clientEditRequest.getBirthDay());
        client.setFullName(clientEditRequest.getFullName());
        return client;
    }

    @Override
    public Client toEntity(ClientSaveRequest clientSaveRequest) {
        Client client = new Client();
        client.setBirthDay(clientSaveRequest.getBirthDay());
        client.setFullName(clientSaveRequest.getFullName());
        return client;
    }
}
