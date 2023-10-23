package com.price.system.price.service.domain.dto.search;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class SearchPriceQuery {

    @NotNull
    private LocalDateTime requestDate;
    @NotNull
    private Integer brandId;
    @NotNull
    private Integer productId;


}
