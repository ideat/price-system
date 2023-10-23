package com.price.system.price.service.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PriceDto {

    @NotNull
    private Integer priceList;
    @NotNull
    private Integer brandId;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    @NotNull
    private Integer productId;
    @JsonIgnore
    private Integer priority;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String curr;
}
