package com.example.recordatorioss.model

enum class Priority(val label: String) {
    LOW("Baja"),
    MEDIUM("Media"),
    HIGH("Alta")
}

data class Category(
    val id: Int,
    val name: String
)

sealed class ReminderStatus {
    data object Pending : ReminderStatus()
    data object Completed: ReminderStatus()
    data class Postponed(val until: String) : ReminderStatus()
}

val ReminderStatus.label: String
    get() = when (this) {
        ReminderStatus.Pending -> "Pendiente"
        ReminderStatus.Completed -> "Completado"
        is ReminderStatus.Postponed -> "Pospuesto hasta $until"
    }

data class Reminder(
    val id: Int,
    val title: String,
    val description: String? = null,
    val category: Category,
    val priority: Priority,
    val status: ReminderStatus = ReminderStatus.Pending,
    val dueDate: String? = null
)