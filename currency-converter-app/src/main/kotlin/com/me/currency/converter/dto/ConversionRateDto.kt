package com.me.currency.converter.dto

import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.entity.Currency
import jakarta.validation.constraints.*
import java.math.BigDecimal

data class ConversionRateDto(
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

    fun toEntity(): ConversionRate = ConversionRate(
        rate = this.rate, toCurrency = Currency(
            name = this.name, code = this.code
        )
    )
}
