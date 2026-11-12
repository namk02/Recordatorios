package com.example.recordatorioss.data

import androidx.compose.ui.graphics.Color
import com.example.recordatorioss.model.Category
import com.example.recordatorioss.model.Priority
import com.example.recordatorioss.model.Reminder
import com.example.recordatorioss.model.ReminderStatus

object SampleData {
    val categories: Set<Category> = setOf(
        Category(1,"Trabajo"),
        Category(2,"Estudio"),
        Category(3,"Hogar"),
        Category(4,"Salud"),
        Category(1,"Trabajo")
    )

    val categoryColors: Map<String, Color> = mapOf(
        "Trabajo" to Color(0xFF1E88E5),
        "Estudio" to Color(0xFF8E24AA),
        "Hogar" to Color(0xFF43A047),
        "Salud" to Color(0xFFE53935)
    )

    private fun cat(id: Int) = categories.first {it.id == id}

    val reminders: List<Reminder> = listOf(
        Reminder(1,"Entregar informe", "Enviar PDF",
            cat(1), Priority.HIGH, ReminderStatus.Pending, "15/11/20206"),
        Reminder(2,"Estudiar Inglés", null,
            cat(2), Priority.MEDIUM, ReminderStatus.Pending),
        Reminder(3, "Comprar verduras", "Feria del Domingo",
            cat(4), Priority.LOW, ReminderStatus.Completed),
        Reminder(4, "Control médico", "Ayunar antes de examenes",
            cat(4), Priority.HIGH, ReminderStatus.Postponed("20/11/2026"), "20/11/2026"),
        Reminder(5, "Reunión trabajo", null,
            cat(3), Priority.LOW, ReminderStatus.Pending)
    )

    fun byStatus(status: ReminderStatus): List<Reminder> =
        reminders.filter { it.status == status }

    fun byPriority(priority: Priority): List<Reminder> =
        reminders.filter { it.priority == priority}
}