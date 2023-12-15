package com.me.currency.converter.service

import com.me.currency.converter.entity.ConversionRate

interface IConversionRateService {

    fun save(conversionRate: ConversionRate) : ConversionRate
    fun findById(id: Long): ConversionRate
    fun delete(id: Long)
}