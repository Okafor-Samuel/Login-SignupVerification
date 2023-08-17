package com.mocosstore.ecommerceapplication.Exception;

import com.mocosstore.ecommerceapplication.Exception.UsersException.EmailOrPasswordNotValid;
import com.mocosstore.ecommerceapplication.Exception.UsersException.PasswordDoesNotMatchException;
import com.mocosstore.ecommerceapplication.Exception.UsersException.UsersAlreadyExistsException;
import com.mocosstore.ecommerceapplication.Exception.UsersException.UsersNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error-> errors.put(error.getField(),error.getDefaultMessage()));
        return errors;
    }

    @ExceptionHandler(UsersNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> userNotFound(UsersNotFoundException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }

    @ExceptionHandler(UsersAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> userAlreadyExist(UsersAlreadyExistsException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }

    @ExceptionHandler(PasswordDoesNotMatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> mismatchPassword(PasswordDoesNotMatchException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }

    @ExceptionHandler(EmailOrPasswordNotValid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> mismatchDetails(EmailOrPasswordNotValid ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
}
