package com.hackaton.agrotech.exception;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class ResponseUser {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
