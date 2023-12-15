package com.me.currency.converter.dto

import com.me.currency.converter.entity.ConversionRate
import java.math.BigDecimal

class ConversionRateUpdateDto(
    var rate: BigDecimal,
    val name: String,
    val code: String
) {

    fun toEntity(conversionRate: ConversionRate): ConversionRate {
        conversionRate.rate = this.rate
        conversionRate.toCurrency.name = this.name
        conversionRate.toCurrency.code = this.code

        return conversionRate
    }
}
