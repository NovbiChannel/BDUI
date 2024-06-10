package com.example.ui

import com.example.layout.Align
import com.example.layout.Size
import com.example.layout.Size.*
import kotlinx.serialization.Serializable
import javax.swing.GroupLayout.Alignment

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

    override fun toJson(): MutableMap<String, String> {
        return config
    }
}