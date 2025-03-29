package ru.cherepanov.test.task.dynamica.service.web;

import org.springframework.ui.Model;
import ru.cherepanov.test.task.dynamica.model.request.BookEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.BookSaveRequest;

public interface BookWebService {

    void prepareAddBookForm(Model model);

    void prepareEditForm(Long id, Model model);

    void save(BookSaveRequest bookSaveRequest);

    void edit(Long id, BookEditRequest bookEditRequest);

    void prepareModelGetPage(Model model, int pageNumber, int action);
}
