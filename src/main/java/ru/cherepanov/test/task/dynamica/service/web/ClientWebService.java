package ru.cherepanov.test.task.dynamica.service.web;

import org.springframework.ui.Model;
import ru.cherepanov.test.task.dynamica.model.request.ClientEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.ClientSaveRequest;


public interface ClientWebService {


    void prepareModelGetPage(Model model, int pageNumber, int action);

    void prepareSaveClientForm(Model model);

    void prepareEditClientForm(Long id, Model model);

    void save(ClientSaveRequest saveRequest);

    void edit(ClientEditRequest clientEditRequest);
}
