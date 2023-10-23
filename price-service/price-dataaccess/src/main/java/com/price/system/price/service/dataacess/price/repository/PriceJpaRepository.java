package com.price.system.price.service.dataacess.price.repository;

import com.price.system.price.service.dataacess.price.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity,Integer> {

    @Query(value = "select * from prices " +
            "where START_DATE <= :requestDate " +
            "and END_DATE >= :requestDate " +
            "and PRODUCT_ID = :productId " +
            "and BRAND_ID = :brandId", nativeQuery = true)
    List<PriceEntity> findAllByStartDateAndEndDateAndProductIdAndBrandId(
            @Param("requestDate") LocalDateTime requestDate,
            @Param("productId") Integer productId,
            @Param("brandId") Integer brandId);

}
