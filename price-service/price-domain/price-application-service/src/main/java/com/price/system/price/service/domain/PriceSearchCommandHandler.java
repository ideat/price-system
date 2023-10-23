package com.price.system.price.service.domain;

import com.price.system.price.service.domain.dto.PriceDto;
import com.price.system.price.service.domain.dto.search.SearchPriceQuery;
import com.price.system.price.service.domain.entity.Price;
import com.price.system.price.service.domain.exception.PriceNotFoundException;
import com.price.system.price.service.domain.mapper.PriceDataMapper;
import com.price.system.price.service.domain.ports.output.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class PriceSearchCommandHandler {

    private final PriceDataMapper priceDataMapper;
    private final PriceRepository priceRepository;

    public PriceSearchCommandHandler(PriceDataMapper priceDataMapper, PriceRepository priceRepository) {
        this.priceDataMapper = priceDataMapper;
        this.priceRepository = priceRepository;
    }

    @Transactional(readOnly = true)
    public Optional<PriceDto> pricesSearch(SearchPriceQuery searchPriceQuery){
        List<Price> priceListResult = priceRepository.findPricesByDateRequestAndProductIdAndBrandId(searchPriceQuery.getRequestDate(),
                searchPriceQuery.getProductId(), searchPriceQuery.getBrandId());

        if(priceListResult.isEmpty()){
            log.warn("Could not find prices with Brand Id: {}, Product Id: {} and date {}",
                    searchPriceQuery.getBrandId(), searchPriceQuery.getProductId(),searchPriceQuery.getRequestDate());
            throw new PriceNotFoundException("Could not find prices with Brand Id: " + searchPriceQuery.getBrandId()
            + " Product Id: " + searchPriceQuery.getProductId() + "and date " + searchPriceQuery.getRequestDate());
        }


        return priceDataMapper.priceToCreatePriceResponse(priceListResult);
    }
}
