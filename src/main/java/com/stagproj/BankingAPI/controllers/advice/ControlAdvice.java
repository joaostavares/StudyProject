package com.stagproj.BankingAPI.controllers.advice;

import com.stagproj.BankingAPI.core.ApiErrors;
import com.stagproj.BankingAPI.exceptions.ExceptionMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControlAdvice {

    @ExceptionHandler(ExceptionMethod.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrors handleExceptionMethod(ExceptionMethod ex) {
        String mensagem = ex.getMessage();
        return new ApiErrors(mensagem);
    }
}
