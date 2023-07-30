package ru.sirniky.back.exeption;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String messageIdNotFound) {
        super(messageIdNotFound);
    }
}

