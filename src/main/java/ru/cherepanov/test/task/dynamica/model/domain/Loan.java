package ru.cherepanov.test.task.dynamica.model.domain;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "loans", schema = "library")
@SequenceGenerator(name = "loan_gen", sequenceName = "loan_seq", allocationSize = 1)
public class Loan {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "loan_gen")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id",  updatable = false)
    private Book book;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", updatable = false)
    private Client client;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
