package com.example.finalproject.Advice;

import com.example.finalproject.Dto.Api;
import com.example.finalproject.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StoreAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException (ApiException e){
        String message =e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

}
