package com.example.timecalculator.domain.model

data class TimeEntry(val id: Int, val hours: Int, val minutes: Int) {
    val totalMinutes: Int get() = hours * 60 + minutes
}