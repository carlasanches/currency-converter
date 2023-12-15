package com.me.currency.converter.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class ConversionRate(
    @Column(nullable = false, unique = true) @Embedded val toCurrency: Currency = Currency(),
    @Column(nullable = false) var rate: BigDecimal = BigDecimal.ZERO,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
