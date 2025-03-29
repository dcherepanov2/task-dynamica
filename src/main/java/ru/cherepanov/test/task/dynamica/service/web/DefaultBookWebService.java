package ru.cherepanov.test.task.dynamica.service.web;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.cherepanov.test.task.dynamica.model.request.BookEditRequest;
import ru.cherepanov.test.task.dynamica.model.request.BookSaveRequest;
import ru.cherepanov.test.task.dynamica.model.response.BookResponse;
import ru.cherepanov.test.task.dynamica.service.db.DbBookService;

@Service
public class DefaultBookWebService implements BookWebService {

    private final DbBookService dbBookService;

    public DefaultBookWebService(DbBookService dbBookService) {
        this.dbBookService = dbBookService;
    }

    @Override
    public void prepareAddBookForm(Model model) {
        model.addAttribute("book", new BookSaveRequest());
    }

    @Override
    public void prepareEditForm(Long id, Model model) {
        BookResponse book = dbBookService.findById(id);
        model.addAttribute("book", book);
    }

    @Override
    public void save(BookSaveRequest bookSaveRequest) {
        dbBookService.save(bookSaveRequest);
    }

    @Override
    public void edit(Long id, BookEditRequest bookEditRequest) {
        bookEditRequest.setId(id); //TODO: передавать в hidden поле значение с помощью thymeleaf
        dbBookService.edit(bookEditRequest);
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
        model.addAttribute("books", dbBookService.findAll(pageNumber));
    }
}
