package com.example.handler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.exception.BaseException;
import com.example.utils.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public Result handleBaseException(BaseException e) {
        return Result.error(e.getMessage());
    }
}
