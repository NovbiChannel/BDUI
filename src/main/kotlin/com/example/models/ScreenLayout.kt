package com.example.models

import com.example.layout.Component
import kotlinx.serialization.Serializable
@Serializable
data class ScreenLayout(val id: Int, val name: String, val component: Component)
