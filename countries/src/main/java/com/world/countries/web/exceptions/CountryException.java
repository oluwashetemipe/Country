package com.world.countries.web.exceptions;

public class CountryException extends Exception{
    public CountryException() {
    }

    public CountryException(String message) {
        super(message);
    }

    public CountryException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryException(Throwable cause) {
        super(cause);
    }
}
