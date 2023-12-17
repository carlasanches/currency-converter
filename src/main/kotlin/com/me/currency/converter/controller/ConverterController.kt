package com.me.currency.converter.controller

import com.me.currency.converter.dto.ConverterView
import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.service.impl.ConversionRateService
import com.me.currency.converter.service.impl.ConverterService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
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

    private val logger: Logger = LogManager.getLogger(ConverterController::class.java)
    @PatchMapping("/{fromCurrency}/{toCurrency}/{amount}")
    fun convertCurrency(
        @PathVariable fromCurrency: String,
        @PathVariable toCurrency: String,
        @PathVariable amount: BigDecimal
    ): ResponseEntity<ConverterView> {
        val conversionRate: ConversionRate = this.conversionRateService.findById(toCurrency)
        val convertedValue: BigDecimal = this.converterService.convertCurrency(conversionRate, amount)
        val response = ResponseEntity.status(HttpStatus.OK).body(ConverterView(conversionRate, convertedValue))
        logger.info("convertCurrency method response: $response")
        return response
    }
}