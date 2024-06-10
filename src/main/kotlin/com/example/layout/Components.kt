package com.example.layout

import com.example.ui.Modification
import com.example.ui.Modify
import kotlinx.serialization.Serializable

@Serializable
data class Component(val type: String, val modification: MutableMap<String, String> = Modify().toJson(), val children: List<Component> = emptyList())

fun div(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("div", modify.toJson(), children.toList())
}
fun text(text: String, textColor: String, modify: Modification = Modify(), vararg children: Component): Component {
    return Component("text", modify.text(text).textColor(textColor).toJson(), children.toList())
}
fun column(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("column", modify.toJson(), children.toList())
}
fun row(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("row", modify.toJson(), children.toList())
}
fun image(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("image", modify.toJson(), children.toList())
}
fun button(modify: Modification = Modify(), vararg children: Component): Component {
    return Component("button", modify.toJson(), children.toList())
}