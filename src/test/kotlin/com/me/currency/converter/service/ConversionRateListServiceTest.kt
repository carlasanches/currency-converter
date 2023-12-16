package com.me.currency.converter.service

import com.me.currency.converter.entity.ConversionRateList
import com.me.currency.converter.service.impl.ConversionRateListService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
class ConversionRateListServiceTest {

    private val conversionRateListService: ConversionRateListService = ConversionRateListService()

    @Test
    fun `should create a list of conversion rates`() {
        //when
        val current: ConversionRateList = conversionRateListService.initializeCurrencies()

        //then
        Assertions.assertThat(current).isNotNull
        Assertions.assertThat(current).isExactlyInstanceOf(ConversionRateList::class.java)

    }
}