package com.example.recordatorioss

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.recordatorioss.data.SampleData
import com.example.recordatorioss.model.Priority
import com.example.recordatorioss.model.ReminderStatus
import com.example.recordatorioss.ui.ReminderListScreen
import com.example.recordatorioss.ui.theme.RecordatoriossTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Verificación de filtros y Set (se ve en Logcat)
        Log.d("Recordatorios", "Categorías únicas: ${SampleData.categories.size}")
        Log.d("Recordatorios", "Pendientes: ${SampleData.byStatus(ReminderStatus.Pending).size}")
        Log.d("Recordatorios", "Prioridad alta: ${SampleData.byPriority(Priority.HIGH).size}")

        setContent {
            RecordatoriossTheme {
                ReminderListScreen(reminders = SampleData.reminders)
            }
        }
    }
}