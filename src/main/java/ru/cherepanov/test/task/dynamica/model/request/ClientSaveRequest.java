package ru.cherepanov.test.task.dynamica.model.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ClientSaveRequest {

    @NotBlank(message = "ФИО не должно быть пустым")
    private String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
