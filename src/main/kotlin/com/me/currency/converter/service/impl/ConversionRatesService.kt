package com.me.currency.converter.service.impl

import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.entity.ConversionRates
import com.me.currency.converter.entity.Currency
import com.me.currency.converter.service.IConversionRatesService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ConversionRatesService : IConversionRatesService {
    override fun initializeCurrencies(): ConversionRates {
        val conversionRatesList =  mutableListOf(
            ConversionRate(rate = BigDecimal(0.19),
                toCurrency = Currency(name = "Euro", code = "EUR")
            ),
            ConversionRate(rate = BigDecimal(0.20),
                toCurrency = Currency(name = "United States Dollar", code = "USD")
            ),
            ConversionRate(rate = BigDecimal(0.16),
                toCurrency = Currency(name = "Pound Sterling", code = "GBP")
            ),
            ConversionRate(rate = BigDecimal(160.25),
                toCurrency = Currency(name = "Argentine Peso", code = "ARS")
            )
        )

        return ConversionRates(conversionRatesList)
    }
}