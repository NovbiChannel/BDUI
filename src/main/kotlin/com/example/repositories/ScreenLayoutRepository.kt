package com.example.repositories

import com.example.layout.*
import com.example.models.ScreenLayout
import com.example.ui.Modify

sealed interface ScreenLayoutRepository {
    fun getAllScreenLayouts(): List<ScreenLayout>
    fun getScreenLayoutById(id: Int): ScreenLayout?
}
class ScreenLayoutRepositoryImpl : ScreenLayoutRepository {
    private val homeLayout = div(
        Modify()
            .width(Size.MATH_PARENT)
            .height(Size.MATH_PARENT)
            .background("#ffffff"),
        image(
            Modify()
                .width(50)
                .height(50)
                .align(Align.CENTER)
                .image("https://clck.ru/3BBMfo"),
            text(
                "Заголовок",
                "#ffffff",
                Modify()
                    .align(Align.CENTER_HORIZONTAL)
            )
        ),
        column(
            Modify()
                .width(Size.MATH_PARENT),
            row(
                Modify()
                    .width(Size.MATH_PARENT),
                text(
                    "Текст в столбце 1",
                    "#000000",
                    Modify()
                        .width(Size.MATH_PARENT)
                        .background("#ffffff")
                ),
                text(
                    "Текст в столбце 2",
                    "#000000",
                    Modify()
                        .width(Size.MATH_PARENT)
                        .background("#ffffff")
                )
            ),
            text(
                "Текст в колонке",
                "#000000",
                Modify()
                    .width(Size.MATH_PARENT)
                    .background("#ffffff")
            )
        )
    )
    private val screenLayouts = listOf(
        ScreenLayout(1, "Home Screen", homeLayout),
        ScreenLayout(2, "Login Screen", homeLayout)
    )

    override fun getAllScreenLayouts(): List<ScreenLayout> = screenLayouts

    override fun getScreenLayoutById(id: Int): ScreenLayout? = screenLayouts.find { it.id == id }
}