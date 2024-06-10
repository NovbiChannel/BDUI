package com.example.screens

import com.example.layout.*
import com.example.ui.Modify
import javax.swing.GroupLayout

class HomeScreen {
    companion object {
        val comp = div(
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
    }
}