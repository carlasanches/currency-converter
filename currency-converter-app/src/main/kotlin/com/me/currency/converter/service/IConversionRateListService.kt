package com.me.currency.converter.service

import com.me.currency.converter.entity.ConversionRateList

interface IConversionRateListService {
    fun initializeCurrencies() : ConversionRateList
}