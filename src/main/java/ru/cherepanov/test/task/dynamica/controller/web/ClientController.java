package ru.cherepanov.test.task.dynamica.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cherepanov.test.task.dynamica.model.WebResult;
import ru.cherepanov.test.task.dynamica.model.request.ClientEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.ClientSaveRequest;
import ru.cherepanov.test.task.dynamica.service.web.ClientWebService;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientWebService clientWebService;

    public ClientController(ClientWebService clientWebService) {
        this.clientWebService = clientWebService;
    }

    @GetMapping
    public String getPages(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "-1") int action,
            Model model
    ) {
        return WebResult.withoutValid()
                .onSuccessVoid(() -> clientWebService.prepareModelGetPage(model, pageNumber, action))
                .fold(() -> "clients/list");
    }

    @GetMapping("/save")
    public String showAddForm(Model model) {
        return WebResult.withoutValid()
                .onSuccessVoid(() -> clientWebService.prepareSaveClientForm(model))
                .fold(() -> "clients/add");
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        return WebResult.withoutValid()
                .onSuccessVoid(() -> clientWebService.prepareEditClientForm(id, model))
                .fold(() -> "clients/edit");
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ClientSaveRequest clientSaveRequest, BindingResult result) {
        return WebResult.withValid(result)
                .onSuccessVoid(() -> clientWebService.save(clientSaveRequest))
                .fold(
                        () -> "client/add",
                        () -> "redirect:/clients"
                );
    }

    @PostMapping("/edit/{id}")
    public String updateClient(
            @PathVariable Long id,
            @Valid @ModelAttribute ClientEditRequest clientEditRequest,
            BindingResult result
    ) {
        return WebResult.withValid(result)
                .onSuccessVoid(() -> clientWebService.edit(clientEditRequest))
                .fold(
                        () -> "clients/edit",
                        () -> "redirect:/clients"
                );
    }
}
