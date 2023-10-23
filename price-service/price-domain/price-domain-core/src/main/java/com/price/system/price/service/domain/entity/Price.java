package com.price.system.price.service.domain.entity;

import com.price.system.domain.entity.AggregateRoot;
import com.price.system.domain.valueObject.*;

import java.time.LocalDateTime;


public class Price extends AggregateRoot<PriceList>  {

    private final BrandId brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final ProductId productId;
    private final Integer priority;
    private final Money price;
    private final Currency curr;


    public BrandId getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
    public ProductId getProductId() {
        return productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public Money getPrice() {
        return price;
    }

    public Currency getCurr() {
        return curr;
    }



    private Price(Builder builder) {
        super.setId(builder.priceList);
        brandId = builder.brandId;
        startDate = builder.startDate;
        endDate = builder.endDate;
        productId = builder.productId;
        priority = builder.priority;
        price = builder.price;
        curr = builder.curr;
    }

    public static Builder builder(){
        return new Builder();
    }


    public static final class Builder {
        private PriceList priceList;
        private BrandId brandId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private ProductId productId;
        private Integer priority;
        private Money price;
        private Currency curr;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder priceList(PriceList val) {
            priceList = val;
            return this;
        }

        public Builder brandId(BrandId val) {
            brandId = val;
            return this;
        }

        public Builder startDate(LocalDateTime val) {
            startDate = val;
            return this;
        }

        public Builder endDate(LocalDateTime val){
            endDate = val;
            return this;
        }
        public Builder productId(ProductId val) {
            productId = val;
            return this;
        }

        public Builder priority(Integer val) {
            priority = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder curr(Currency val) {
            curr = val;
            return this;
        }

        public Price build() {
            return new Price(this);
        }
    }
}
