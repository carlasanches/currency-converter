package com.me.currency.converter.dto

import com.me.currency.converter.entity.ConversionRate
import java.math.BigDecimal

data class ConversionRateView(
    var rate: BigDecimal,
    val name: String,
    val code: String
) {

    constructor(conversionRate: ConversionRate): this (
        rate = conversionRate.rate,
        name = conversionRate.toCurrency.name,
        code = conversionRate.toCurrency.code
    )
}
