package com.mocosstore.ecommerceapplication.Exception.UsersException;

public class EmailOrPasswordNotValid extends RuntimeException{
    public EmailOrPasswordNotValid(String message){
        super(message);
    }
}
