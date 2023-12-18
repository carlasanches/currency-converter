package com.me.currency.converter.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Currency(
    @Column(nullable = false, unique = true) var name: String = "",
    @Column(nullable = false, unique = true) var code: String = ""
)
