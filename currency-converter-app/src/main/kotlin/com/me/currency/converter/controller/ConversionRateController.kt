package com.me.currency.converter.controller

import com.me.currency.converter.dto.ConversionRateDto
import com.me.currency.converter.dto.ConversionRateUpdateDto
import com.me.currency.converter.dto.ConversionRateView
import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.service.impl.ConversionRateService
import jakarta.validation.Valid
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/conversion_rates")
class ConversionRateController(
    private val conversionRateService: ConversionRateService
) {

    private val logger: Logger = LogManager.getLogger(ConversionRateController::class.java)

    @PostMapping
    fun saveConversionRate(@RequestBody @Valid conversionRateDto: ConversionRateDto): ResponseEntity<String> {
        val savedCurrency = this.conversionRateService.save(conversionRateDto.toEntity())
        val response =
            ResponseEntity.status(HttpStatus.CREATED).body("Currency ${savedCurrency.toCurrency.name} saved!")
        logger.info("saveConversionRate method response: $response")
        return response
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<ConversionRateView> {
        val conversionRate: ConversionRate = this.conversionRateService.findById(id)
        val conversionRateView = ConversionRateView(conversionRate)

        val response = ResponseEntity.status(HttpStatus.OK).body(conversionRateView)
        logger.info("findById method response: $response")
        return response
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteConversionRate(@PathVariable id: String) = this.conversionRateService.delete(id)

    @PatchMapping("/{id}")
    fun updateConversionRate(
        @PathVariable id: String,
        @RequestBody @Valid conversionRateUpdateDto: ConversionRateUpdateDto
    ): ResponseEntity<ConversionRateView> {
        val conversionRate: ConversionRate = this.conversionRateService.findById(id)
        val conversionToUpdate: ConversionRate = conversionRateUpdateDto.toEntity(conversionRate)
        val conversionUpdated: ConversionRate = this.conversionRateService.save(conversionToUpdate)

        val response = ResponseEntity.status(HttpStatus.OK).body(ConversionRateView(conversionUpdated))
        logger.info("updateConversionRate method response: $response")
        return response
    }
}