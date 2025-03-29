package ru.cherepanov.test.task.dynamica.model.domain;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "clients")
@SequenceGenerator(name = "client_gen", sequenceName = "client_seq", allocationSize = 1)
public class Client {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "client_gen")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
