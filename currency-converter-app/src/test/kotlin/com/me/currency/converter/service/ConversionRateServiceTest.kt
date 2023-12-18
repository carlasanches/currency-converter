package com.me.currency.converter.service

import com.me.currency.converter.entity.ConversionRate
import com.me.currency.converter.entity.Currency
import com.me.currency.converter.repository.ConversionRateRepository
import com.me.currency.converter.service.impl.ConversionRateService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.lang.RuntimeException
import java.math.BigDecimal
import java.util.*

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class ConversionRateServiceTest {

    @MockK
    lateinit var conversionRateRepository: ConversionRateRepository
    @InjectMockKs
    lateinit var conversionRateService: ConversionRateService

    @Test
    fun `should create a conversion rate`() {
        //given
        val fakeConversionRate: ConversionRate = buildConversionRate()
        every { conversionRateRepository.save(any()) } returns fakeConversionRate

        //when
        val current: ConversionRate = conversionRateService.save(fakeConversionRate)

        //then
        Assertions.assertThat(current).isNotNull
        Assertions.assertThat(current).isSameAs(fakeConversionRate)
        verify(exactly = 1) {conversionRateRepository.save(fakeConversionRate)}
    }

    @Test
    fun `should find a conversion rate by id`() {
        //given
        val fakeId = "EUR"
        val fakeConversionRate: ConversionRate = buildConversionRate(id = fakeId)
        every { conversionRateRepository.findById(fakeId) } returns Optional.of(fakeConversionRate)

        //when
        val current: ConversionRate = conversionRateService.findById(fakeId)

        //then
        Assertions.assertThat(current).isNotNull
        Assertions.assertThat(current).isExactlyInstanceOf(ConversionRate::class.java)
        Assertions.assertThat(current).isSameAs(fakeConversionRate)
        verify(exactly = 1) {conversionRateRepository.findById(fakeId)}
    }

    @Test
    fun `should not find a conversion rate by invalid id and throw a RuntimeException`() {
        //given
        val fakeId = "EUR"
        every { conversionRateRepository.findById(fakeId) } returns Optional.empty()

        //when
        //then
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { conversionRateService.findById(fakeId) }
            .withMessage("Id $fakeId not found.")
        verify(exactly = 1) {conversionRateRepository.findById(fakeId)}
    }

    @Test
    fun `should delete a conversion rate by id`() {
        //given
        val fakeId = "EUR"
        val fakeConversionRate: ConversionRate = buildConversionRate(id = fakeId)
        every { conversionRateRepository.findById(fakeId) } returns Optional.of(fakeConversionRate)
        every { conversionRateRepository.delete(fakeConversionRate) } just runs

        //when
        conversionRateService.delete(fakeId)

        //then
        verify(exactly = 1) {conversionRateRepository.findById(fakeId)}
        verify(exactly = 1) {conversionRateRepository.delete(fakeConversionRate)}
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