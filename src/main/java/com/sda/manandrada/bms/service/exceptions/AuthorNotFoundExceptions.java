package com.sda.manandrada.bms.service.exceptions;

public class AuthorNotFoundExceptions extends Exception {

    private final Integer authorId;

    public AuthorNotFoundExceptions(String message,Integer authorId) {
        super(message);
        this.authorId=authorId;
    }

    public  Integer getAuthorId() {
        return authorId;
    }
}
