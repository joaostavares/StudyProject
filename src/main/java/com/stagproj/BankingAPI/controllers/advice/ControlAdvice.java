package com.stagproj.BankingAPI.controllers.advice;

import com.stagproj.BankingAPI.core.ApiErrors;
import com.stagproj.BankingAPI.exceptions.ExceptionMethod;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControlAdvice {

    @ExceptionHandler(ExceptionMethod.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrors handleExceptionMethod(ExceptionMethod ex) {
        String mensagem = ex.getMessage();
        return new ApiErrors(mensagem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return new ApiErrors(erros);

    }


    //apenas para reduzir o erro de Json, não tenho certeza se é o metodo mais correto, e tem chance de ser alterado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrors handleDefaulHandleExceptionResolver(HttpMessageNotReadableException ex) {
        String mensagem = ex.getMessage();
        return new ApiErrors(mensagem);
    }
}
