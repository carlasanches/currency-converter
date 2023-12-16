package com.me.currency.converter.controller

import com.me.currency.converter.dto.ConversionRateDto
import com.me.currency.converter.dto.ConversionRateUpdateDto
import com.me.currency.converter.dto.ConversionRateView
import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.service.impl.ConversionRateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/conversion_rates")
class ConversionRateController(
    private val conversionRateService: ConversionRateService
) {

    @PostMapping
    fun saveConversionRate(@RequestBody conversionRateDto: ConversionRateDto): ResponseEntity<String> {
        val savedCurrency = this.conversionRateService.save(conversionRateDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Currency ${savedCurrency.toCurrency.name} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<ConversionRateView> {
        val conversionRate: ConversionRate = this.conversionRateService.findById(id)
        val conversionRateView = ConversionRateView(conversionRate)

        return ResponseEntity.status(HttpStatus.OK).body(conversionRateView)
    }

    @DeleteMapping("/{id}")
    fun deleteConversionRate(@PathVariable id: String) = this.conversionRateService.delete(id)

    @PatchMapping("/{id}")
    fun updateConversionRate(
        @PathVariable id: String,
        @RequestBody conversionRateUpdateDto: ConversionRateUpdateDto
    ): ResponseEntity<ConversionRateView> {
        val conversionRate: ConversionRate = this.conversionRateService.findById(id)
        val conversionToUpdate: ConversionRate = conversionRateUpdateDto.toEntity(conversionRate)
        val conversionUpdated: ConversionRate = this.conversionRateService.save(conversionToUpdate)

        return ResponseEntity.status(HttpStatus.OK).body(ConversionRateView(conversionUpdated))
    }
}