package com.workshop.android_challenge

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class BoletoUnitTest {
    var boleto: Boleto? = null

    @Before
    fun setup() {
        boleto = Boleto(
            dueDate = "2021-12-21",
            amount = 129.90,
            receiver = "Our Company"
        )
    }

    @Test
    fun createBoleto_fillDueDate_shouldBeSuccefull() {
        val expected = "2021-12-21"
        assertEquals(expected, boleto?.dueDate)
    }

    @Test
    fun createBoleto_fillAmount_shouldBeSuccefull() {
        val expected = 129.90
        assertEquals(expected, boleto?.amount)
    }

    @Test
    fun createBoleto_fillReceiver_shouldBeSuccefull() {
        val expected = "Our Company"
        assertEquals(expected, boleto?.receiver)
    }

    @After
    fun tearDown() {
         boleto = null
    }
}