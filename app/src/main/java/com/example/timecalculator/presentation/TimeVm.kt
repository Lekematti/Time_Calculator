package com.example.timecalculator.presentation

import androidx.lifecycle.ViewModel
import com.example.timecalculator.domain.model.TimeEntry
import com.example.timecalculator.domain.usecase.TimeCalculator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TimeVm : ViewModel() {
    private val _ui = MutableStateFlow(UiState())
    val ui: StateFlow<UiState> = _ui

    fun addEntry(hours: Int, minutes: Int) {
        if (hours == 0 && minutes == 0) return
        _ui.update { state ->
            val e = TimeEntry(state.nextId, hours, minutes)
            state.copy(entries = state.entries + e, nextId = state.nextId + 1)
        }
    }

    fun removeEntry(id: Int) {
        _ui.update { state -> state.copy(entries = state.entries.filterNot { it.id == id }) }
    }

    fun toggleLanguage() {
        _ui.update { it.copy(isFinnish = !it.isFinnish) }
    }

    fun totalMinutes(): Int = TimeCalculator.totalMinutes(_ui.value.entries)
    fun formatTotal(total: Int): String = TimeCalculator.formatTotal(total)
}