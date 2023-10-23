package com.price.system.price.service.dataacess.price.adapter;

import com.price.system.price.service.dataacess.price.mapper.PriceDataAccessMapper;
import com.price.system.price.service.dataacess.price.repository.PriceJpaRepository;
import com.price.system.price.service.domain.entity.Price;
import com.price.system.price.service.domain.ports.output.PriceRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;
    private final PriceDataAccessMapper priceDataAccessMapper;

    public PriceRepositoryImpl(PriceJpaRepository priceJpaRepository,
                               PriceDataAccessMapper priceDataAccessMapper) {
        this.priceJpaRepository = priceJpaRepository;
        this.priceDataAccessMapper = priceDataAccessMapper;
    }

    @Override
    public List<Price> findPricesByDateRequestAndProductIdAndBrandId(LocalDateTime requestDate, Integer productId, Integer brandId) {
        return priceDataAccessMapper
                .priceEntityToPrice(priceJpaRepository.findAllByStartDateAndEndDateAndProductIdAndBrandId(requestDate,productId,brandId));


    }
}
