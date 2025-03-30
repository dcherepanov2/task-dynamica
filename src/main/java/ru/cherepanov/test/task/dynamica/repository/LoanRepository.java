package ru.cherepanov.test.task.dynamica.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cherepanov.test.task.dynamica.model.domain.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(
            value = "SELECT l FROM Loan l JOIN FETCH l.client c JOIN FETCH l.book b",
            countQuery = "SELECT COUNT(l) FROM Loan l"
    )
    Page<Loan> findPageWithClientAndBook(Pageable pageable);
}
