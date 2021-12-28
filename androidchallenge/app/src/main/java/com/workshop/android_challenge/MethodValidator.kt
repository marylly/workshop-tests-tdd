package com.workshop.android_challenge

import java.time.LocalDate

class MethodValidator {

    fun validate(method: Boleto): Boleto {
        val dueDate = method.dueDate.toLocalDate()
        val currentDate = LocalDate.now()

        if (dateGreaterThanCurrentDate(dueDate, currentDate))
            throw IllegalArgumentException("")

        return method
    }

    private fun dateGreaterThanCurrentDate(date: LocalDate, currentDate: LocalDate?) =
        date < currentDate

    private fun String.toLocalDate(): LocalDate =
        LocalDate.parse(this)
}