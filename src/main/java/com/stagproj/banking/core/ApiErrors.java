package com.stagproj.banking.core;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class ApiErrors {
    @Getter
    private final List<String> errors;

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String mensagem){
        this.errors = Collections.singletonList(mensagem);
    }
}
