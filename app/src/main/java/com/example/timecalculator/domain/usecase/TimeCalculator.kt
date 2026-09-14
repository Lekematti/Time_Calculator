package com.example.timecalculator.domain.usecase

import com.example.timecalculator.domain.model.TimeEntry

object TimeCalculator {
    fun totalMinutes(entries: List<TimeEntry>): Int = entries.sumOf { it.totalMinutes }

    fun formatTotal(totalMinutes: Int): String {
        val h = totalMinutes / 60
        val m = totalMinutes % 60
        return "${h}H:${m}M"
    }
}