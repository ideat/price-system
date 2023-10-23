package com.price.system.price.service.domain.ports.input.service;

import com.price.system.price.service.domain.dto.PriceDto;
import com.price.system.price.service.domain.dto.search.SearchPriceQuery;
import com.price.system.price.service.domain.entity.Price;
import jakarta.validation.Valid;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface PriceApplicationService {

    Optional<PriceDto> findPricesByDateRequestAndProductIdAndBrandId(@Valid SearchPriceQuery searchPriceQuery);

}
