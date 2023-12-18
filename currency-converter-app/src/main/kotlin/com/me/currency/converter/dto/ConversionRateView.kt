package com.me.currency.converter.dto

import com.me.currency.converter.entity.ConversionRate
import jakarta.validation.constraints.*
import java.math.BigDecimal

data class ConversionRateView(
    @field:NotNull(message = "Currency rate must not be null!")
    @field:Positive(message = "Currency rate must be a positive value!")
    var rate: BigDecimal,
    @field:NotEmpty(message = "Currency name must not be empty!")
    @field:NotBlank(message = "Currency name must not be blank!")
    val name: String,
    @field:NotEmpty(message = "Currency code must not be empty!")
    @field:NotBlank(message = "Currency code must not be blank!")
    @field:Size(min = 3, max = 3, message = "Currency code size must be 3!")
    val code: String
) {

    constructor(conversionRate: ConversionRate): this (
        rate = conversionRate.rate,
        name = conversionRate.toCurrency.name,
        code = conversionRate.toCurrency.code
    )
}
