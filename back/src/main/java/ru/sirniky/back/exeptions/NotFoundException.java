package ru.sirniky.back.exeptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String messageIdNotFound) {
        super(messageIdNotFound);
    }
}

