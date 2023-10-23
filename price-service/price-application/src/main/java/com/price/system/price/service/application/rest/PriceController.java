package com.price.system.price.service.application.rest;

import com.price.system.price.service.application.exception.handler.PriceGlobalExceptionHandler;
import com.price.system.price.service.domain.dto.PriceDto;
import com.price.system.price.service.domain.dto.search.SearchPriceQuery;
import com.price.system.price.service.domain.exception.PriceDomainException;
import com.price.system.price.service.domain.ports.input.service.PriceApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value="/prices")
public class PriceController {

    private final PriceApplicationService priceApplicationService;

    public PriceController(PriceApplicationService priceApplicationService) {
        this.priceApplicationService = priceApplicationService;
    }

    @GetMapping("/getprice")
    public ResponseEntity<PriceDto> getPrices(@RequestParam("brandId") Integer brandId,
                                              @RequestParam("productId") Integer productId,
                                              @RequestParam("requestDate") String requestDate){



        Optional<PriceDto> priceDto = priceApplicationService.findPricesByDateRequestAndProductIdAndBrandId(new SearchPriceQuery(convert(requestDate),brandId,productId));

        return ResponseEntity.ok(priceDto.get());
    }

    private LocalDateTime convert(String date){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH.mm.ss")
                    .withZone(ZoneId.systemDefault());
            return LocalDateTime.from(formatter.parse(date));
        }catch (Exception ex){
            throw new PriceDomainException("Invalid format date: " + date + " valid format  yyyy-mm-dd-HH.mm.ss");
        }

    }
}
