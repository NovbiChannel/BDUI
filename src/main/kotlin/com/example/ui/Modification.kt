package com.example.ui

import com.example.layout.Constants.MATCH_PARENT
import javax.swing.GroupLayout.Alignment

interface Modification {
    fun background(color: String): Modification
    fun width(width: Int): Modification
    fun setMaxWidth(): Modification
    fun height(height: Int): Modification
    fun setMaxHeight(): Modification
    fun align(alignment: Alignment): Modification
    fun text(text: String): Modification
    fun textColor(color: String): Modification
    fun toJson(): Map<String, Any>
}

class Modify : Modification {
    private val config = mutableMapOf<String, Any>()

    override fun background(color: String): Modification {
        config["background"] = color
        return this
    }

    override fun width(width: Int): Modification {
        config["width"] = width
        return this
    }

    override fun setMaxWidth(): Modification {
        config["width"] = MATCH_PARENT
        return this
    }

    override fun height(height: Int): Modification {
        config["height"] = height
        return this
    }

    override fun setMaxHeight(): Modification {
        config["height"] = MATCH_PARENT
        return this
    }

    override fun align(alignment: Alignment): Modification {
        config["align"] = alignment.name
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

    override fun toJson(): Map<String, Any> = config
}
