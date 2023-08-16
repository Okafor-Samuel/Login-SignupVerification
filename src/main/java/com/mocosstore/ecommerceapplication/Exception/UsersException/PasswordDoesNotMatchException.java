package com.mocosstore.ecommerceapplication.Exception.UsersException;

public class PasswordDoesNotMatchException extends RuntimeException{
    public PasswordDoesNotMatchException(String message){
        super(message);
    }
}
