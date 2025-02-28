package ru.mesler.polyusbot.util

enum class MessageTexts(val text: String) {
    START_MESSAGE(
        """
        Добро пожаловать в Полюс бот, выберите один из пунктов ниже
    """.trimIndent()
    ),
    CONTINUE_MESSAGE(
        """
        Выберите один из пунктов ниже
    """.trimIndent()
    )
}