package com.samsoft

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.io.Closeable
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean


class KafkaOrderProducer(val brokers: String) : Runnable, Closeable {

    private val objectMapper = ObjectMapper()
    private val itemTopic = "items"
    private val paymentTopic = "payments"
    private val stop = AtomicBoolean(false)

    override fun run() {
        val producer = createProducer()
        producer.use { producer ->
            while (!stop.get()) {
                FakerOrderSupplier.getOrder(10).forEach {
                    producer.send(ProducerRecord(itemTopic, it.item.orderId, objectMapper.writeValueAsString(it.item)))
                    producer.send(
                        ProducerRecord(
                            paymentTopic,
                            it.payment.orderId,
                            objectMapper.writeValueAsString(it.payment)
                        )
                    )
                    println("Sent message to ${it.item.name} and payment")
                }
            }
        }
    }


    private fun createProducer(): Producer<String, String> {
        val props = Properties()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = brokers
        props[ProducerConfig.CLIENT_ID_CONFIG] = "KafkaExampleProducer"
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        return KafkaProducer(props)
    }

    override fun close() {
        stop.set(true)
    }
}

fun main() {
    val producer = KafkaOrderProducer("localhost:9092")
    producer.use { Thread(it).start() }
}