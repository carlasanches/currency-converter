package com.me.currency.converter.service

import com.me.currency.converter.entity.ConversionRate
import java.math.BigDecimal

interface IConverterService {

    fun convertCurrency(conversionRate: ConversionRate, amount: BigDecimal) : BigDecimal
}