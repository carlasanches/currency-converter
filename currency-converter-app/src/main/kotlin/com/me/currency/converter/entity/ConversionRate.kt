package com.me.currency.converter.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class ConversionRate(
    @Column(nullable = false, unique = true) @Embedded val toCurrency: Currency = Currency(),
    @Column(nullable = false, scale = 5) var rate: BigDecimal = BigDecimal.ZERO,
    @Id val id: String = toCurrency.code
)
