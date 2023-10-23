package com.price.system.price.service.domain.mapper;

import com.price.system.price.service.domain.dto.PriceDto;
import com.price.system.price.service.domain.entity.Price;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PriceDataMapper {

    public Optional<PriceDto> priceToCreatePriceResponse(List<Price> prices){
        return prices.stream()
                .map(price -> PriceDto.builder()
                        .brandId(price.getBrandId().getValue())
                        .priceList(price.getId().getValue())
                        .startDate(price.getStartDate())
                        .endDate(price.getEndDate())
                        .priority(price.getPriority())
                        .productId(price.getProductId().getValue())
                        .price(price.getPrice().getAmount())
                        .curr(String.valueOf(price.getCurr()))
                        .build())
                .max(Comparator.comparing(PriceDto::getPriority));


    }
}
