package ru.cherepanov.test.task.dynamica.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cherepanov.test.task.dynamica.model.WebResult;
import ru.cherepanov.test.task.dynamica.model.request.BookEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.BookSaveRequest;
import ru.cherepanov.test.task.dynamica.service.web.BookWebService;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookWebService bookWebService;

    public BookController(BookWebService bookWebService) {
        this.bookWebService = bookWebService;
    }

    @GetMapping
    public String getPage(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "-1") int action,
            Model model
    ) {
        return WebResult.withoutValid()
                .onSuccessVoid(() -> bookWebService.prepareModelGetPage(model, pageNumber, action))
                .fold(() -> "books/list");
    }

    @GetMapping("/save")
    public String showAddForm(Model model) {
        return WebResult.withoutValid()
                .onSuccessVoid(() -> bookWebService.prepareAddBookForm(model))
                .fold(() -> "books/save");
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        return WebResult.withoutValid()
                .onSuccessVoid(() -> bookWebService.prepareEditForm(id, model))
                .fold(() -> "books/edit");
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute BookSaveRequest book, BindingResult result) {
        return WebResult.withValid(result)
                .onSuccessVoid(() -> bookWebService.save(book))
                .fold(
                        () -> "books/save",
                        () -> "redirect:/books"
                );
    }

    @PostMapping("/edit/{id}")
    public String updateBook(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute BookEditRequest bookEditRequest,
            BindingResult result
    ) {
        return WebResult.withValid(result)
                .onSuccessVoid(() -> bookWebService.edit(id, bookEditRequest))
                .fold(
                        () -> "books/edit",
                        () -> "redirect:/books"
                );
    }
}
