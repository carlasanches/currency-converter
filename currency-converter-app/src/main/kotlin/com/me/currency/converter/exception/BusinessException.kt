package com.me.currency.converter.exception

data class BusinessException(override val message: String?) : RuntimeException(message) {
}