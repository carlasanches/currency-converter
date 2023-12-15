package com.me.currency.converter.service.impl

import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.service.IConverterService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ConverterService : IConverterService {
    override fun convertCurrency(conversionRate: ConversionRate, amount: BigDecimal): BigDecimal {
        return amount * conversionRate.rate
    }
}