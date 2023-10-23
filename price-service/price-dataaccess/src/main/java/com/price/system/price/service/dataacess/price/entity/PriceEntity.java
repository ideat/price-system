package com.price.system.price.service.dataacess.price.entity;

import com.price.system.domain.valueObject.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="prices")
@Entity
public class PriceEntity {
    @Id
    private Integer priceList;
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer productId;
    private Integer priority;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Currency curr;

}
