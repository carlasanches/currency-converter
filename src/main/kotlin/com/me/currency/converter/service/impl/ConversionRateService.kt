package com.me.currency.converter.service.impl

import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.repository.ConversionRateRepository
import com.me.currency.converter.service.IConversionRateService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ConversionRateService(
    private val conversionRateRepository: ConversionRateRepository
) : IConversionRateService {
    override fun save(conversionRate: ConversionRate): ConversionRate =
        this.conversionRateRepository.save(conversionRate)

    override fun findById(id: Long): ConversionRate =
        this.conversionRateRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id not found.")
        }

    override fun delete(id: Long) = this.conversionRateRepository.deleteById(id)
}