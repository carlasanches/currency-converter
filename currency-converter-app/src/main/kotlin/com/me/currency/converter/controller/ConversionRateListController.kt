package com.me.currency.converter.controller

import com.me.currency.converter.entity.ConversionRateList
import com.me.currency.converter.service.impl.ConversionRateService
import com.me.currency.converter.service.impl.ConversionRateListService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/save_all_currencies")
class ConversionRateListController(
    private val conversionRateListService: ConversionRateListService,
    private val conversionRateService: ConversionRateService
) {

    private val logger: Logger = LogManager.getLogger(ConversionRateListController::class.java)
    @PostMapping
    fun saveAllConversionRates(): ResponseEntity<String> {
        val conversionRateList: ConversionRateList = this.conversionRateListService.initializeCurrencies()
        conversionRateList.conversionRateList.map { this.conversionRateService.save(it) }
        val response = ResponseEntity.status(HttpStatus.CREATED).body("All currencies saved!")
        logger.info("saveAllConversionRates method response: $response")
        return response
    }
}