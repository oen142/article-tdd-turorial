package com.wani.articletddturorial.modules.common.exception;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Getter
@JsonRootName("errors")
public class ErrorResponse {

    private List<String> bodies;

    private ErrorResponse(List<String> bodies) {
        this.bodies = bodies;
    }

    public static ErrorResponse from(BindingResult bindingResult) {
        List<String> messages = new ArrayList<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            messages.add(error.getDefaultMessage());
        }

        return new ErrorResponse(messages);
    }

    public static ErrorResponse from(String message) {
        return new ErrorResponse(List.of(message));
    }

}
