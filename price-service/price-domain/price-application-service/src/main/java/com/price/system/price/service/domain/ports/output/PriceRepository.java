package com.price.system.price.service.domain.ports.output;

import com.price.system.price.service.domain.entity.Price;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository {

    List<Price> findPricesByDateRequestAndProductIdAndBrandId(LocalDateTime requestDate, Integer productId, Integer brandId);
}
