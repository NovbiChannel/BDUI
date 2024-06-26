package com.example.plugins

import com.example.models.DeepLink
import com.example.models.ScreenLayout
import com.example.repositories.ScreenLayoutRepositoryImpl
import com.example.services.ScreenLayoutService
import com.example.utils.JsonUtils
import com.example.utils.jsonToHtml
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Application.configureRouting() {
    val service = ScreenLayoutService(ScreenLayoutRepositoryImpl())
    routing {
        static("/static") {
            files("src/main/kotlin/com/example/java_script")
        }
        get("/test-layout") {
            val screen = service.getTestScreenLayout()
            val jsonString = JsonUtils.toJson(screen, ScreenLayout.serializer())
            call.respondText(jsonString, contentType = ContentType.Application.Json)
        }
        get("/") {
            val homeScreen = service.getScreenLayoutById(1)
            val jsonString = JsonUtils.toJson(homeScreen, ScreenLayout.serializer())
            val htmlDoc = jsonToHtml(jsonString)
            call.respondText(htmlDoc, contentType = ContentType.Text.Html)
        }
        get("/screen-layouts") {
            val screenLayouts = service.getAllScreenLayouts()
            val jsonString = JsonUtils.toJson(screenLayouts, ListSerializer(ScreenLayout.serializer()))
            call.respondText(jsonString, contentType = ContentType.Application.Json)
        }
        get("/screen-layouts/{id}") {
            val id = call.parameters["id"]!!.toInt()
            val screenLayout = service.getScreenLayoutById(id)
            val jsonString = JsonUtils.toJson(screenLayout, ScreenLayout.serializer())
            call.respondText(jsonString, contentType = ContentType.Application.Json)
        }
        post("/test-fun") {
            val data = call.receiveText()
            val deepLink = JsonUtils.fromJson(data, DeepLink.serializer()).deepLink
            println("Click button! Deep link: $deepLink")
            call.respond(HttpStatusCode.OK)
        }
    }
}