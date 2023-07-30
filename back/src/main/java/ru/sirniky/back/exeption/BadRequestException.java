package ru.sirniky.back.exeption;

public class BadRequestException  extends RuntimeException{
    public BadRequestException(String msg) {
        super(msg);
    }
}
