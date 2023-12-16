package com.me.currency.converter.controller

import com.me.currency.converter.entity.ConversionRates
import com.me.currency.converter.service.impl.ConversionRateService
import com.me.currency.converter.service.impl.ConversionRatesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/save_all_currencies")
class ConversionRatesController(
    private val conversionRatesService: ConversionRatesService,
    private val conversionRateService: ConversionRateService
) {
    @PostMapping
    fun saveAllConversionRates(): ResponseEntity<String> {
        val conversionRates: ConversionRates = this.conversionRatesService.initializeCurrencies()
        conversionRates.conversionRates.map { this.conversionRateService.save(it) }
        return ResponseEntity.status(HttpStatus.CREATED).body("All currencies saved!")
    }
}