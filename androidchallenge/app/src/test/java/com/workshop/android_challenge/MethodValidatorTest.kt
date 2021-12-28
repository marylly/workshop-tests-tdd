package com.workshop.android_challenge

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MethodValidatorTest {
    val validator = MethodValidator()

    @Before
    fun setUp() {
    }

    @Test
    fun validate_boletoDueDate_shouldBeSuccesfull() {
        val expected = Boleto("2021-12-21", 139.99, "Our Company")
        val actual = validator.validate(expected)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun validate_whenBoletoInvalidDueDate_shouldTrowsException() {}

    @After
    fun tearDown() {}
}