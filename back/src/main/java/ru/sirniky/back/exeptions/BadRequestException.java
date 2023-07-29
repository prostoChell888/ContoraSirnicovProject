package ru.sirniky.back.exeptions;

public class BadRequestException  extends RuntimeException{
    public BadRequestException(String msg) {
        super(msg);
    }
}
