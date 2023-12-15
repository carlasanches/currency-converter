package com.me.currency.converter.dto

import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.entity.Currency
import java.math.BigDecimal

data class ConversionRateDto(
    var rate: BigDecimal,
    val name: String,
    val code: String
) {

    fun toEntity(): ConversionRate = ConversionRate(
        rate = this.rate,
        toCurrency = Currency(
            name = this.name,
            code = this.code
        )
    )
}
