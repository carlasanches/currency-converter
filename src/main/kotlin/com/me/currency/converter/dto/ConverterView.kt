package com.me.currency.converter.dto

import com.me.currency.converter.entity.ConversionRate
import java.math.BigDecimal

data class ConverterView(
    val rate: BigDecimal,
    val amount: BigDecimal
) {

    constructor(conversionRate: ConversionRate, convertedValue: BigDecimal) : this (
        rate = conversionRate.rate,
        amount = convertedValue
    )
}