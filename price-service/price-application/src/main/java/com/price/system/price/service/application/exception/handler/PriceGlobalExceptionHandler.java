package com.price.system.price.service.application.exception.handler;

import com.price.system.application.handler.ErrorDTO;
import com.price.system.application.handler.GlobalExceptionHandler;
import com.price.system.price.service.domain.exception.PriceDomainException;
import com.price.system.price.service.domain.exception.PriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class PriceGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {PriceDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(PriceDomainException priceDomainException){
        log.error(priceDomainException.getMessage(), priceDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(priceDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value={PriceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(PriceNotFoundException priceNotFoundException){
        log.error(priceNotFoundException.getMessage(), priceNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(priceNotFoundException.getMessage())
                .build();
    }
}
