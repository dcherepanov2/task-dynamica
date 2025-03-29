package ru.cherepanov.test.task.dynamica.model;

import org.springframework.validation.BindingResult;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebResult {

    private final boolean isValid;
    private final Logger log = Logger.getLogger(WebResult.class.getName());

    public static WebResult withoutValid() {
        return new WebResult(true);
    }

    public static WebResult withValid(BindingResult result) {
        return new WebResult(result);
    }

    private WebResult(boolean isValid) {
        this.isValid = isValid;
    }

    private WebResult(BindingResult result) {
        this.isValid = !result.hasErrors();
    }

    public WebResult onSuccessVoid(Runnable action) {
        try {
            if (this.isValid) {
                action.run();
            }
        } catch (Exception e) {
            log.log(Level.WARNING, e.getMessage());
        }
        return this;
    }

    public String fold(Supplier<String> onError, Supplier<String> onSuccess) {
        return this.isValid ? onSuccess.get() : onError.get();
    }

    public String fold(Supplier<String> onSuccess) {
        return onSuccess.get();
    }
}
