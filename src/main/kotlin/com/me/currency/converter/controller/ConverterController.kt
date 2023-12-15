package com.me.currency.converter.controller

import com.me.currency.converter.dto.ConverterView
import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.service.impl.ConversionRateService
import com.me.currency.converter.service.impl.ConverterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/v1/currency")
class ConverterController(
    private val conversionRateService: ConversionRateService,
    private val converterService: ConverterService
) {
    @PatchMapping("/{fromCurrency}/{toCurrency}/{amount}")
    fun convertCurrency(
        @PathVariable fromCurrency: String,
        @PathVariable toCurrency: String,
        @PathVariable amount: BigDecimal
    ): ResponseEntity<ConverterView> {
        val conversionRate: ConversionRate = this.conversionRateService.findById(toCurrency)
        val convertedValue: BigDecimal = this.converterService.convertCurrency(conversionRate, amount)
        return ResponseEntity.status(HttpStatus.OK).body(ConverterView(conversionRate, convertedValue))
    }
}