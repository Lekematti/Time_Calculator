package com.example.timecalculator.presentation

import com.example.timecalculator.domain.model.TimeEntry

data class UiState(
    val entries: List<TimeEntry> = emptyList(),
    val nextId: Int = 0,
    val isFinnish: Boolean = false
)
