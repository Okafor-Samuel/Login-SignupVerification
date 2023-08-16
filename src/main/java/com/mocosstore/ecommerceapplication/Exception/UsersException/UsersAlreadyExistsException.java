package com.mocosstore.ecommerceapplication.Exception.UsersException;

public class UsersAlreadyExistsException extends RuntimeException{
    public UsersAlreadyExistsException(String message){
        super(message);
    }
}
