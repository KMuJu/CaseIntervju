package com.KMuJu.CaseIntervju.exception;

/**
 * BadRequestException
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
    
    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
