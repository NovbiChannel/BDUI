package com.example.layout

import com.example.ui.Modification
import com.example.ui.Modify
import kotlinx.serialization.Serializable

@Serializable
data class Component(
    val type: String,
    val modification: MutableMap<String, String> = Modify().toJson(),
    val children: List<Component> = emptyList()
)

fun div(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("div", modify.toJson(), children.toList())
}
fun text(text: String, textColor: String, modify: Modification = Modify(), vararg children: Component): Component {
    val config = modify.toJson()
    return Component(
        "text",
        modify
            .text(text, config)
            .textColor(textColor, config)
            .toJson(),
        children.toList())
}
fun image(url: String, modify: Modification = Modify(), vararg children: Component): Component {
    val config = modify.toJson()
    return Component("image", modify.image(url, config).toJson(), children.toList())
}
fun button(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("button", modify.toJson(), children.toList())
}
fun space(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("space", modify.toJson(), children.toList())
}
private fun Modification.text(text: String, config: MutableMap<String, String>): Modification {
    config["text"] = text
    return this
}
private fun Modification.textColor(textColor: String, config: MutableMap<String, String>): Modification {
    config["textColor"] = textColor
    return this
}
private fun Modification.image(url: String, config: MutableMap<String, String>): Modification {
    config["image"] = url
    return this
}