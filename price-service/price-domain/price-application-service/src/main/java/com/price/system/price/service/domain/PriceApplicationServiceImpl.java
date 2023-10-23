package com.price.system.price.service.domain;

import com.price.system.price.service.domain.dto.PriceDto;
import com.price.system.price.service.domain.dto.search.SearchPriceQuery;
import com.price.system.price.service.domain.entity.Price;
import com.price.system.price.service.domain.ports.input.service.PriceApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Slf4j
@Validated
@Service
public class PriceApplicationServiceImpl implements PriceApplicationService {

    private final PriceSearchCommandHandler priceSearchCommandHandler;

    public PriceApplicationServiceImpl(PriceSearchCommandHandler priceSearchCommandHandler) {
        this.priceSearchCommandHandler = priceSearchCommandHandler;
    }

    @Override
    public Optional<PriceDto> findPricesByDateRequestAndProductIdAndBrandId(SearchPriceQuery searchPriceQuery) {

        return priceSearchCommandHandler.pricesSearch(searchPriceQuery);
    }
}
