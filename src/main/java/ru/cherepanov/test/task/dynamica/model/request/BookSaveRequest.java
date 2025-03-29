package ru.cherepanov.test.task.dynamica.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static ru.cherepanov.test.task.dynamica.constant.BookRequestRegexConstant.ISBN_REGEX_PATTERN;


public class BookSaveRequest {

    @NotBlank(message = "Название книги не должно быть пустым")
    @Size(max = 255, message = "Название книги не должно превышать 255 символов")
    private String title;

    @NotBlank(message = "Автор не должен быть пустым")
    private String author;

    @NotBlank(message = "ISBN не должен быть пустым")
    @Pattern(regexp = ISBN_REGEX_PATTERN, message = "ISBN должен состоять из 13 цифр")
    private String isbn;

    private LocalDateTime createdAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
