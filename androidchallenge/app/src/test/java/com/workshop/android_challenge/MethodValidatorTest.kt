package com.workshop.android_challenge

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

const val NOW_DATE = "2021-12-28"

class MethodValidatorTest {
    val validator = MethodValidator()

    @Before
    fun setUp() {
        mockkStatic(LocalDate::class)
        every { LocalDate.now() } returns LocalDate.parse(NOW_DATE)
    }

    @Test
    fun validate_boletoDueDate_shouldBeSuccesfull() {
        val expected = Boleto("2021-12-28", 139.99, "Our Company")
        val actual = validator.validate(expected)
        Assert.assertEquals(expected, actual)
    }

    @Test(expected = IllegalArgumentException::class)
    fun validate_whenBoletoInvalidDueDate_shouldTrowsException() {
        val expected = Boleto("2021-12-21", 139.99, "Our Company")
        validator.validate(expected)
    }

    @After
    fun tearDown() {
    }
}