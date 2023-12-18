package com.me.currency.converter.dto

import com.me.currency.converter.entity.ConversionRate
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import java.math.BigDecimal

data class ConverterView(
    @field:NotNull(message = "Currency rate must not be null!")
    @field:Positive(message = "Currency rate must be a positive value!")
    val rate: BigDecimal,
    @field:NotNull(message = "Currency amount must not be null!")
    @field:PositiveOrZero(message = "Currency amount must be a positive value!")
    val amount: BigDecimal
) {

    constructor(conversionRate: ConversionRate, convertedValue: BigDecimal) : this (
        rate = conversionRate.rate,
        amount = convertedValue
    )
}