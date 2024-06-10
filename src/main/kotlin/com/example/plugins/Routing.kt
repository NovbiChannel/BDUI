package com.example.plugins

import com.example.layout.*
import com.example.repositories.ScreenLayoutRepositoryImpl
import com.example.screens.HomeScreen
import com.example.services.ScreenLayoutService
import com.example.ui.Modify
import com.example.utils.JsonUtils
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.*
import javax.swing.GroupLayout

fun Application.configureRouting() {
    routing {
        get("/preview") {
            call.respondText("Preview", contentType = ContentType.Text.Html)
        }
        get("/screen-layouts") {
            val service = ScreenLayoutService(ScreenLayoutRepositoryImpl())
            call.respondText(service.getAllScreenLayouts(), contentType = ContentType.Application.Json)
        }
        get("/screen-layouts/{id}") {
            val id = call.parameters["id"]!!.toInt()
            val service = ScreenLayoutService(ScreenLayoutRepositoryImpl())
            call.respondText(service.getScreenLayoutById(id), contentType = ContentType.Application.Json)
        }
        get("/div") {
            call.respondText(HomeScreen.comp.toJson().toString(), contentType = ContentType.Application.Json)
        }
    }
}