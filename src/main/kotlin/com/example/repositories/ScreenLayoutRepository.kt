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
                    .fontSize(16)
            )
        ),
        div(
            Modify()
                .width(Size.MATH_PARENT)
                .display(Table.ROOT)
                .role(Role.TABLE),
            div(
                Modify()
                    .width(Size.MATH_PARENT)
                    .display(Table.ROW)
                    .role(Role.ROW),
                textColumn("текст в столбце 1"),
                space(Modify().width(30)),
                textColumn("текст в столбце 2")
            ),
            text(
                "Текст в колонке",
                "#000000",
                Modify()
                    .width(Size.MATH_PARENT)
                    .background("#ffffff")
                    .align(Align.CENTER)
                    .display(Table.ROW)
                    .role(Role.ROW)
                    .padding(10)
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
            div(
                Modify()
                    .width(Size.MATH_PARENT)
                    .display(Table.ROW),
                image(
                    Modify()
                        .image("https://gdz.ru/img/i/vk-button-icon.svg")
                        .display(Table.CELL)
                ),
                space(Modify().width(30)),
                text(
                    "Button",
                    "#000000",
                    Modify()
                        .display(Table.CELL)
                        .align(Align.CENTER_VERTICAL)
                )
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
fun textColumn(text: String): Component {
    return text(
        text,
        "#ffffff",
        Modify()
            .width(Size.HALF_PARENT)
            .align(Align.CENTER)
            .padding(30, 30, 30, 30)
            .background("#000000")
            .display(Table.CELL)
            .role(Role.CELL)
            .borderRadius(8)
    )
}