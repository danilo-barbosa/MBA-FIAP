package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class InvalidAssistException extends RuntimeException{
    private String description;
    public InvalidAssistException(String message, String description){
        super(message);
        this.description = description;
    }

}
