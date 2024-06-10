package com.example.utils

import kotlinx.serialization.json.*

fun jsonToHtml(json: String): String {
    val jsonObject = Json.parseToJsonElement(json).jsonObject
    return buildHtml(jsonObject)
}

fun buildHtml(jsonObject: JsonObject): String {
    val type = jsonObject["type"]?.jsonPrimitive?.content
    val modification = jsonObject["modification"]?.jsonObject
    val children = jsonObject["children"]?.jsonArray

    val html = StringBuilder()
    html.append("<$type")

    modification?.let {
        for ((key, value) in it) {
            html.append(" $key=\"${value.jsonPrimitive.content}\"")
        }
    }

    html.append(">")

    children?.let {
        for (child in it) {
            html.append(buildHtml(child.jsonObject))
        }
    }

    html.append("</$type>")
    return html.toString()
}