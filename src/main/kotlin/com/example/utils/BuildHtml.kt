package com.example.utils

import kotlinx.serialization.json.*

fun jsonToHtml(json: String): String {
    val jsonObject = Json.parseToJsonElement(json).jsonObject
    val componentObject = jsonObject["component"]?.jsonObject
    return if (componentObject != null) {
        val html = buildHtml(componentObject)
        """
        <html>
        <head>
        <script src="/static/TestFunction.js"></script>
        </head>
        <body>
            $html
        </body>
        </html>
        """
    } else ""
}

fun buildHtml(jsonObject: JsonObject): String {
    val type = jsonObject["type"]?.jsonPrimitive?.content
    val modification = jsonObject["modification"]?.jsonObject
    val children = jsonObject["children"]?.jsonArray

    val html = StringBuilder()
    type?.let {
        html.append("<${typeHtmlTransform(it)}")
    }

    modification?.let {
        val styleAttributes = mutableListOf<String>()
        var innerText: String? = null
        for ((key, value) in it) {
            val attribute = keyHtmlTransform(key)
            if (attribute.startsWith("style")) {
                styleAttributes.add("${attribute.substring(6)}: ${value.jsonPrimitive.content};")
            } else if (attribute == "innerText") {
                innerText = value.jsonPrimitive.content
            } else {
                html.append(" $attribute=\"${value.jsonPrimitive.content}\"")
            }
        }
        if (styleAttributes.isNotEmpty()) {
            val style = " style=\"${styleAttributes.joinToString(" ")}\""
            html.append(style)
        }

        if (type == "button") {
            val onClickFunction = it["onClick"]?.jsonPrimitive?.content
            if (onClickFunction != null) {
                html.append(" onclick=\"$onClickFunction()\"")
            }
        }
        html.append(">")
        if (innerText != null) {
            html.append(innerText)
        }
    }?:run {
        html.append(">")
    }

    children?.let {
        for (child in it) {
            html.append(buildHtml(child.jsonObject))
        }
    }

    type?.let {
        html.append("</${typeHtmlTransform(it)}>")
    }
    return html.toString()
}

fun keyHtmlTransform(key: String): String {
    return when (key) {
        "justify-content","font-size", "display", "width", "height", "border-radius", "padding", "padding-left", "padding-right",
        "padding-bottom", "padding-top", "margin", "margin-left", "margin-right", "margin-bottom",
        "margin-top" -> "style=$key"
        "image" -> "src"
        "background" -> "style=background-color"
        "align" -> "style=text-align"
        "text" -> "innerText"
        "textColor" -> "style=color"
        "role", "onclick" -> key
        else -> ""
    }
}

fun typeHtmlTransform(type: String): String {
    return when (type) {
        "image" -> "img"
        "button" -> "button"
        else -> "div"
    }
}