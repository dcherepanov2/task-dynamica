package ru.cherepanov.test.task.dynamica.service.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.cherepanov.test.task.dynamica.model.request.ClientEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.ClientSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.ClientResponse;
import ru.cherepanov.test.task.dynamica.service.mapper.ClientMapper;
import ru.cherepanov.test.task.dynamica.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DefaultDbClientService implements DbClientService {

    @Value("${db.find-all.clients.limit}")
    private Integer findAllLimit;
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    public DefaultDbClientService(ClientMapper clientMapper, ClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<ClientResponse> findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toResponse);
    }

    @Override
    public void save(ClientSaveRequest clientSaveRequest) {
        Optional.ofNullable(clientSaveRequest)
                .map(clientMapper::toEntity)
                .ifPresent(clientRepository::save);
    }

    @Transactional
    @Override
    public void edit(ClientEditRequest clientEditRequest) {
        Optional.ofNullable(clientEditRequest)
                .map(clientMapper::toEntity)
                .ifPresent(clientRepository::save);
    }

    @Transactional
    @Override
    public Page<ClientResponse> findAll(int pageNumber) {
        return Optional.of(pageNumber)
                .map(pageNumberLocal -> PageRequest.of(pageNumber, findAllLimit))
                .map(clientRepository::findAll)
                .map(page -> page.map(clientMapper::toResponse))
                .orElseThrow(IllegalStateException::new);
    }
}
