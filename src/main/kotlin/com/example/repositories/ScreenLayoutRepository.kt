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
                .width(150)
                .height(150)
                .align(Align.CENTER)
                .borderRadius(15)
                .image("https://clck.ru/3BBMfo"),
            text(
                "Заголовок",
                "#000000",
                Modify()
                    .align(Align.CENTER)
                    .padding(10, 10, 10, 10)
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
                    "#6E5160",
                    Modify()
                        .width(Size.MATH_PARENT)
                        .background("#FFC618")
                        .padding(30)
                ),
                text(
                    "Текст в столбце 2",
                    "#6E5160",
                    Modify()
                        .width(Size.MATH_PARENT)
                        .margin(10, 10, 30, 20)
                        .background("#5E490F")
                )
            ),
            text(
                "Текст в колонке",
                "#000000",
                Modify()
                    .width(Size.MATH_PARENT)
                    .background("#ffffff")
            )
        ),
        button(
            Modify()
                .width(200)
                .height(50)
                .borderRadius(8)
                .background("#E337ED")
                .align(Align.CENTER)
            ,
            text(
                "Button",
                "#000000"
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