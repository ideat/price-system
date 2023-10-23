package com.price.system.price.service.domain.exception;

import com.price.system.domain.exception.DomainException;

public class PriceNotFoundException extends DomainException {
    public PriceNotFoundException(String message) {
        super(message);
    }

    public PriceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
