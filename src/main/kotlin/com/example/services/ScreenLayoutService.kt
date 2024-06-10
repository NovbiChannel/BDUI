package com.example.services

import com.example.layout.Component
import com.example.models.ScreenLayout
import com.example.repositories.ScreenLayoutRepository
import com.example.utils.JsonUtils
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer

class ScreenLayoutService(private val repository: ScreenLayoutRepository) {
    fun getAllScreenLayouts(): List<ScreenLayout> {
        return repository.getAllScreenLayouts()
    }

    fun getScreenLayoutById(id: Int): ScreenLayout {
        return repository.getScreenLayoutById(id)?: ScreenLayout(0, "", Component("null"))
    }
}