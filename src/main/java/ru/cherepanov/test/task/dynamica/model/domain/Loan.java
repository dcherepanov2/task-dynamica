package ru.cherepanov.test.task.dynamica.model.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "client_full_name", nullable = false, length = 255)
    private String clientFullName;

    @Column(name = "client_birth_day", nullable = false)
    private LocalDate clientBirthDay;

    @Column(name = "book_title", nullable = false, length = 255)
    private String bookTitle;

    @Column(name = "book_isbn", nullable = false, length = 255)
    private String bookIsbn;

    @Column(name = "loan_date", nullable = false)
    @CreationTimestamp
    private LocalDate loanDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

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
