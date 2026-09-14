package com.example.timecalculator.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timecalculator.presentation.TimeVm

@Composable
fun TimeCalculatorScreen(vm: TimeVm = viewModel()) {
    var hoursInput by remember { mutableStateOf("") }
    var minutesInput by remember { mutableStateOf("") }

    val uiState by vm.ui.collectAsState()

    val t = if (uiState.isFinnish) {
        mapOf(
            "title" to "Aikalaskin",
            "hours" to "Tunnit",
            "minutes" to "Minuutit",
            "add" to "Lisää",
            "remove" to "Poista",
            "total" to "Yhteensä",
            "langButton" to "Vaihda englanniksi"
        )
    } else {
        mapOf(
            "title" to "Time Calculator",
            "hours" to "Hours",
            "minutes" to "Minutes",
            "add" to "Add",
            "remove" to "Remove",
            "total" to "Total",
            "langButton" to "Switch to Finnish"
        )
    }

    val total = vm.totalMinutes()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = t["title"]!!, style = MaterialTheme.typography.headlineMedium)
            Button(onClick = { vm.toggleLanguage() }) { Text(t["langButton"]!!) }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = hoursInput,
                onValueChange = { input -> hoursInput = input.filter { it.isDigit() }.take(3) },
                label = { Text(t["hours"]!!) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = minutesInput,
                onValueChange = { input -> minutesInput = input.filter { it.isDigit() }.take(3) },
                label = { Text(t["minutes"]!!) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                val h = hoursInput.toIntOrNull() ?: 0
                val m = minutesInput.toIntOrNull() ?: 0
                vm.addEntry(h, m)
                hoursInput = ""
                minutesInput = ""
            }) {
                Text(t["add"]!!)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(uiState.entries, key = { it.id }) { entry ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("${entry.hours}H:${entry.minutes}M")
                    TextButton(onClick = { vm.removeEntry(entry.id) }) {
                        Text(t["remove"]!!)
                    }
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = DividerDefaults.Thickness,
            color = DividerDefaults.color
        )

        Text(text = "${t["total"]}: $total min (${vm.formatTotal(total)})",
            style = MaterialTheme.typography.titleLarge)
    }
}