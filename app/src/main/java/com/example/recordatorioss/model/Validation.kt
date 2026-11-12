package com.example.recordatorioss.model

sealed class ValidationResult {
    data object Valid : ValidationResult()
    data class Invalid(val reason: String) : ValidationResult()
}

fun validateTitle(title: String): ValidationResult = when {
    title.isBlank() -> ValidationResult.Invalid("El título no puede estar vacío")
    title.length > 60 -> ValidationResult.Invalid("El t[itulo no puede superar los 60 caracteres")
    else -> ValidationResult.Valid
}


