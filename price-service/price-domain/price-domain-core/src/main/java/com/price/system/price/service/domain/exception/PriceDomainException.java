package com.price.system.price.service.domain.exception;

import com.price.system.domain.exception.DomainException;

public class PriceDomainException extends DomainException {
    public PriceDomainException(String message) {
        super(message);
    }

    public PriceDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
