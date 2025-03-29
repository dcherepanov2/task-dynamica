package ru.cherepanov.test.task.dynamica.model.response;

import java.time.LocalDate;

public class ClientLoanResponse {

    private String fullName;

    private LocalDate birthDay;

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