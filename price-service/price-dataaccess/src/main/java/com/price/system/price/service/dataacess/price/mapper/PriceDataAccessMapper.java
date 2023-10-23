package com.price.system.price.service.dataacess.price.mapper;

import com.price.system.domain.valueObject.*;
import com.price.system.price.service.dataacess.price.entity.PriceEntity;
import com.price.system.price.service.domain.entity.Price;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceDataAccessMapper {

    public List<Price> priceEntityToPrice(List<PriceEntity> priceEntityList){
        return priceEntityList.stream()
                .map(priceEntity ->  Price.builder()
                    .priceList(new PriceList(priceEntity.getPriceList()))
                    .brandId(new BrandId(priceEntity.getBrandId()))
                    .startDate( priceEntity.getStartDate())
                    .endDate(priceEntity.getEndDate())
                    .priority(priceEntity.getPriority())
                    .productId(new ProductId(priceEntity.getProductId()))
                    .price(new Money(priceEntity.getPrice()))
                    .curr(priceEntity.getCurr())
                    .build())
                .collect(Collectors.toList());
    }
}
