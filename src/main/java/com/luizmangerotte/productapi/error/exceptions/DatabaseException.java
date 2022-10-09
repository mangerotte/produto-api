package com.luizmangerotte.productapi.error.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg){
        super(msg);
    }
}
