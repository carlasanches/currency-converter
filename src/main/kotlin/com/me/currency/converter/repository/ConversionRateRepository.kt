package com.me.currency.converter.repository

import com.me.currency.converter.entity.ConversionRate
import org.springframework.data.jpa.repository.JpaRepository

interface ConversionRateRepository: JpaRepository<ConversionRate, String>