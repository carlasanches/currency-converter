package com.me.currency.converter.service

import com.me.currency.converter.entity.ConversionRates

interface IConversionRatesService {
    fun initializeCurrencies() : ConversionRates
}