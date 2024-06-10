package com.example.repositories

import com.example.layout.*
import com.example.models.ScreenLayout
import com.example.ui.Modify
import javax.swing.GroupLayout

sealed interface ScreenLayoutRepository {
    fun getAllScreenLayouts(): List<ScreenLayout>
    fun getScreenLayoutById(id: Int): ScreenLayout?
}
class ScreenLayoutRepositoryImpl : ScreenLayoutRepository {
    private val screenLayouts = listOf(
        ScreenLayout(1, "Home Screen", homeLayout),
        ScreenLayout(2, "Login Screen", homeLayout)
    )
    private val homeLayout = div(
        Modify()
            .setMaxWidth()
            .setMaxHeight()
            .background("#ffffff"),
        div(
            Modify()
                .width(50)
                .height(50)
                .align(GroupLayout.Alignment.CENTER)
                .background("#000000"),
            h(
                "Заголовок",
                "#ffffff",
                Modify()
                    .align(GroupLayout.Alignment.CENTER)
            )
        ),
        column(
            Modify()
                .setMaxWidth(),
            row(
                Modify()
                    .setMaxWidth(),
                p(
                    "Текст в столбце 1",
                    "#000000",
                    Modify()
                        .setMaxWidth()
                        .background("#ffffff")
                ),
                p(
                    "Текст в столбце 2",
                    "#000000",
                    Modify()
                        .setMaxWidth()
                        .background("#ffffff")
                )
            ),
            p(
                "Текст в колонке",
                "#000000",
                Modify()
                    .setMaxWidth()
                    .background("#ffffff")
            )
        )
    )

    override fun getAllScreenLayouts(): List<ScreenLayout> = screenLayouts

    override fun getScreenLayoutById(id: Int): ScreenLayout? = screenLayouts.find { it.id == id }
}