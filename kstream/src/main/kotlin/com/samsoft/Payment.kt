package com.samsoft

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class Payment(
    val orderId: String,
    val amount: BigDecimal,
    val paymentDate: LocalDate,
    val paymentDateTime: LocalDateTime = LocalDateTime.now()
)
