package ru.cherepanov.test.task.dynamica.model.response;

import java.time.LocalDate;


public class LoanResponse {

    private String clientFullName;

    private LocalDate clientBirthDay;

    private String bookTitle;

    private String bookIsbn;

    private LocalDate loanDate;

    private LocalDate returnDate;

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public LocalDate getClientBirthDay() {
        return clientBirthDay;
    }

    public void setClientBirthDay(LocalDate clientBirthDay) {
        this.clientBirthDay = clientBirthDay;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
