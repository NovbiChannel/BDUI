package com.example.layout

import com.example.ui.Modification
import com.example.ui.Modify
import kotlinx.serialization.Serializable

@Serializable
data class Component(val type: String, val modification: Modification = Modify(), val children: List<Component> = emptyList())

fun Component.toJson(): Map<String, Any> {
    val json = mutableMapOf<String, Any>()
    json["type"] = type
    json["modification"] = modification.toJson()
    if (children.isNotEmpty()) {
        json["children"] = children.map { it.toJson() }
    }
    return json
}

fun div(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("div", modify, children.toList())
}
fun h(text: String, textColor: String, modify: Modification = Modify(), vararg children: Component): Component {
    return Component("h_text", modify.text(text).textColor(textColor), children.toList())
}
fun p(text: String, textColor: String, modify: Modification = Modify(), vararg children: Component): Component {
    return Component("p_text", modify.text(text).textColor(textColor), children.toList())
}
fun column(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("column", modify, children.toList())
}
fun row(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("row", modify, children.toList())
}