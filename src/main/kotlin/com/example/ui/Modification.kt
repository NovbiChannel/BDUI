package com.example.ui

import com.example.layout.Align
import com.example.layout.Size
import com.example.layout.Size.*
import kotlinx.serialization.Serializable

sealed class Modification {
    abstract fun background(color: String): Modification
    abstract fun image(link: String): Modification
    abstract fun width(width: Int): Modification
    abstract fun width(size: Size): Modification
    abstract fun height(height: Int): Modification
    abstract fun height(size: Size): Modification
    abstract fun align(align: Align): Modification
    abstract fun text(text: String): Modification
    abstract fun textColor(color: String): Modification
    abstract fun borderRadius(radius: Int): Modification
    abstract fun padding(paddings: Int): Modification
    abstract fun padding(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null): Modification
    abstract fun margin(margins: Int): Modification
    abstract fun margin(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null): Modification
    abstract fun toJson(): MutableMap<String, String>
}

@Serializable
data class Modify(private val config: MutableMap<String, String> = mutableMapOf()) : Modification() {

    override fun background(color: String): Modification {
        config["background"] = color
        return this
    }

    override fun image(link: String): Modification {
        config["image"] = link
        return this
    }

    override fun width(width: Int): Modification {
        config["width"] = width.toString()
        return this
    }

    override fun width(size: Size): Modification {
        config["width"] = when (size) {
            WRAP_CONTENT -> "-1"
            MATH_PARENT -> "100%"
        }
        return this
    }

    override fun height(height: Int): Modification {
        config["height"] = height.toString()
        return this
    }

    override fun height(size: Size): Modification {
        config["height"] = when (size) {
            WRAP_CONTENT -> "-1"
            MATH_PARENT -> "100%"
        }
        return this
    }

    override fun align(align: Align): Modification {
        config["align"] = when (align) {
            Align.LEFT -> "left"
            Align.RIGHT -> "right"
            Align.CENTER -> "center"
            Align.TOP -> "top"
            Align.BOTTOM -> "bottom"
            Align.CENTER_HORIZONTAL -> "center_x"
            Align.CENTER_VERTICAL -> "center_y"
        }
        return this
    }

    override fun text(text: String): Modification {
        config["text"] = text
        return this
    }

    override fun textColor(color: String): Modification {
        config["textColor"] = color
        return this
    }

    override fun borderRadius(radius: Int): Modification {
        config["border-radius"] = radius.toString() + "px"
        return this
    }

    override fun padding(paddings: Int): Modification {
        config["padding"] = paddings.toString() + "px"
        return this
    }

    override fun padding(left: Int?, top: Int?, right: Int?, bottom: Int?): Modification {
        left?.let { config["padding-left"] = it.toString() + "px" }
        top?.let { config["padding-top"] = it.toString() + "px" }
        right?.let { config["padding-right"] = it.toString() + "px" }
        bottom?.let { config["padding-bottom"] = it.toString() + "px" }
        return this
    }

    override fun margin(margins: Int): Modification {
        config["margin"] = margins.toString() + "px"
        return this
    }

    override fun margin(left: Int?, top: Int?, right: Int?, bottom: Int?): Modification {
        left?.let { config["margin-left"] = it.toString() + "px" }
        top?.let { config["margin-top"] = it.toString() + "px" }
        right?.let { config["margin-right"] = it.toString() + "px" }
        bottom?.let { config["margin-bottom"] = it.toString() + "px" }
        return this
    }

    override fun toJson(): MutableMap<String, String> {
        return config
    }
}