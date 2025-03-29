package ru.cherepanov.test.task.dynamica.service.web;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.cherepanov.test.task.dynamica.model.request.ClientEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.ClientSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.ClientResponse;
import ru.cherepanov.test.task.dynamica.service.db.DbClientService;

@Service
public class DefaultClientWebService implements ClientWebService {

    private final DbClientService dbClientService;

    public DefaultClientWebService(DbClientService dbClientService) {
        this.dbClientService = dbClientService;
    }

    @Override
    public void prepareModelGetPage(Model model, int pageNumber, int action) {
        if(action == 0 && pageNumber > 0){
            pageNumber --;
        }
        if(action == 1){
            pageNumber ++;
        }
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("clients", dbClientService.findAll(pageNumber));
    }

    @Override
    public void prepareSaveClientForm(Model model) {
        model.addAttribute("client", new ClientSaveRequest());
    }

    @Override
    public void prepareEditClientForm(Long id, Model model) {
        ClientResponse clientResponse = dbClientService.findById(id);
        model.addAttribute("client", clientResponse);
    }

    @Override
    public void save(ClientSaveRequest saveRequest) {
        dbClientService.save(saveRequest);
    }

    @Override
    public void edit(ClientEditRequest clientEditRequest) {
        dbClientService.edit(clientEditRequest);
    }
}
