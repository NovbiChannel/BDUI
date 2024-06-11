package com.example.repositories

import com.example.layout.*
import com.example.models.ScreenLayout
import com.example.ui.Modify

sealed interface ScreenLayoutRepository {
    fun getAllScreenLayouts(): List<ScreenLayout>
    fun getScreenLayoutById(id: Int): ScreenLayout?
    fun getTestLayout(): ScreenLayout
}
class ScreenLayoutRepositoryImpl : ScreenLayoutRepository {
    private val homeLayout = div(
        Modify()
            .width(Size.MATH_PARENT)
            .height(Size.MATH_PARENT)
            .background("#3f3f3f"),
        image(
            url = "https://clck.ru/3BBMfo",
            Modify()
                .width(150)
                .height(150)
                .align(Align.CENTER)
                .borderRadius(15),
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
                .display(Display.TABLE)
                .role(Role.TABLE),
            div(
                Modify()
                    .width(Size.MATH_PARENT)
                    .display(Display.ROW)
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
                    .display(Display.ROW)
                    .role(Role.ROW)
                    .padding(10)
            )
        ),
        button(
            Modify()
                .width(200)
                .height(50)
                .borderRadius(10)
                .background("#4C75A3")
                .align(Align.CENTER)
                .onClick("testFun()")
            ,
            div(
                Modify()
                    .display(Display.FLEX)
                    .justifyContent(JustifyContent.CENTER),
                image(url = "https://gdz.ru/img/i/vk-button-icon.svg"),
                space(Modify().width(30)),
                text(
                    "VK ID",
                    "#ffffff",
                    Modify()
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
    override fun getTestLayout(): ScreenLayout {
        return ScreenLayout(
            1,
            "TestScreen",
            div(
                Modify()
                    .width(Size.MATH_PARENT)
                    .height(Size.MATH_PARENT)
                    .background("#D7EEF2"),
                div(
                    Modify()
                        .width(Size.MATH_PARENT)
                        .display(Display.CELL),
                    div(
                        Modify()
                            .width(50)
                            .height(50)
                            .borderRadius(8)
                            .background("#83898A")),
                    space(Modify().width(30)),
                    div(
                        Modify()
                            .width(50)
                            .height(50)
                            .borderRadius(15)
                            .background("#83898A")),
                )
            ))
    }
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
            .display(Display.CELL)
            .role(Role.CELL)
            .borderRadius(8)
    )
}