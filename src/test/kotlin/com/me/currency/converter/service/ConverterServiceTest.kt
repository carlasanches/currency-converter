package com.me.currency.converter.service

import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.entity.Currency
import com.me.currency.converter.service.impl.ConverterService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal

@ActiveProfiles("test")
class ConverterServiceTest {

    private val converterService: ConverterService = ConverterService()

    @Test
    fun `should convert the value of a currency into another one`() {
        //given
        val fakeConversionRate: ConversionRate = buildConversionRate()
        val fakeAmount = BigDecimal(Math.random())

        //when
        val current: BigDecimal = converterService.convertCurrency(fakeConversionRate, fakeAmount)

        //then
        Assertions.assertThat(current).isNotNull()
    }

    private fun buildConversionRate(
        name: String = "Euro",
        code: String = "EUR",
        rate: BigDecimal = BigDecimal.valueOf(0.19),
        id: String = "EUR"
    ) = ConversionRate(
        toCurrency = Currency(
            name = name,
            code = code
        ),
        rate = rate,
        id = id
    )
}