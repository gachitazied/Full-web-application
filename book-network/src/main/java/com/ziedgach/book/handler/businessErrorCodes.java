package com.ziedgach.book.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum businessErrorCodes {
    NO_CODE(0, NOT_IMPLEMENTED,"No Code"),
    INCORRECT_CURRENT_PASSWORD(300,BAD_REQUEST,"Current password is incorrect !"),
    NEW_PASSWORD_DOES_NOT_MATCH(301,BAD_REQUEST,"The new password does not match !"),
    ACCOUNT_LOCKED(302,FORBIDDEN,"User account is locked"),
    ACCOUNT_DISABLE(303,FORBIDDEN,"User account is disabled"),
    BAD_CREDENTIALS(302,FORBIDDEN,"Login and / or password is incorrect ") ;



    @Getter
    private final int code ;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus;

    businessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
