package com.samsoft

import com.github.javafaker.Faker
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

object FakerOrderSupplier {

    private val faker = Faker()
    private val random = Random()

    fun getOrder(count: Int = 1): List<Order> = (0..count).map {
        val orderId = UUID.randomUUID().toString()
        val item = Item(orderId, faker.commerce().productName()!!)
        val paymentDate = LocalDate.now().minusDays(random.nextInt().toLong())
        val payment = Payment(
            orderId,
            BigDecimal(random.nextDouble() * 598745000),
            paymentDate,
            paymentDate.atStartOfDay().plusMinutes(random.nextInt(800).toLong())
        )
        Order(item, payment)
    }

}