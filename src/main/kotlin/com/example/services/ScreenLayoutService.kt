package com.example.services

import com.example.models.ScreenLayout
import com.example.repositories.ScreenLayoutRepository
import com.example.utils.JsonUtils
import kotlinx.serialization.builtins.ListSerializer

class ScreenLayoutService(private val repository: ScreenLayoutRepository) {
    fun getAllScreenLayouts(): String {
        val screenLayouts = repository.getAllScreenLayouts()
        // Обработка исключений при сериализации
        return try {
            JsonUtils.toJson(screenLayouts, ListSerializer(ScreenLayout.serializer()))
        } catch (e: Exception) {
            "Serialization error: ${e.message}"
        }
    }

    fun getScreenLayoutById(id: Int): String {
        val screenLayout = repository.getScreenLayoutById(id)
        // Обработка исключений при сериализации
        return try {
            if (screenLayout != null) JsonUtils.toJson(screenLayout, ScreenLayout.serializer()) else "Not Found"
        } catch (e: Exception) {
            "Serialization error: ${e.message}"
        }
    }
}