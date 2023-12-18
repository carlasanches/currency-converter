package com.me.currency.converter.service.impl

import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.repository.ConversionRateRepository
import com.me.currency.converter.service.IConversionRateService
import org.springframework.stereotype.Service
import com.me.currency.converter.exception.BusinessException

@Service
class ConversionRateService(
    private val conversionRateRepository: ConversionRateRepository
) : IConversionRateService {
    override fun save(conversionRate: ConversionRate): ConversionRate =
        this.conversionRateRepository.save(conversionRate)

    override fun findById(id: String): ConversionRate =
        this.conversionRateRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not found.")
        }

    override fun delete(id: String){
        val conversionRate: ConversionRate = this.findById(id)
        this.conversionRateRepository.delete(conversionRate)
    }
}