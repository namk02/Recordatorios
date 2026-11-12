package com.example.recordatorioss.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recordatorioss.data.SampleData
import com.example.recordatorioss.model.Reminder
import com.example.recordatorioss.model.label
import com.example.recordatorioss.ui.theme.RecordatoriossTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderListScreen(reminders: List<Reminder>, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text("Mis recordatorios") }) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(reminders, key = { it.id }) { reminder ->
                ReminderItem(reminder)
            }
        }
    }
}

@Composable
fun ReminderItem(reminder: Reminder) {
    val color = SampleData.categoryColors[reminder.category.name]
        ?: MaterialTheme.colorScheme.primary

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .background(color, CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(reminder.title, style = MaterialTheme.typography.titleMedium)
                reminder.description?.let {
                    Text(it, style = MaterialTheme.typography.bodyMedium)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("Categoría: ${reminder.category.name}", style = MaterialTheme.typography.bodySmall)
                Text("Prioridad: ${reminder.priority.label}", style = MaterialTheme.typography.bodySmall)
                Text("Estado: ${reminder.status.label}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReminderListScreenPreview() {
    RecordatoriossTheme {
        ReminderListScreen(reminders = SampleData.reminders)
    }
}