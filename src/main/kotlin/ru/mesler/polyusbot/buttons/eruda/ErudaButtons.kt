package ru.mesler.polyusbot.buttons.eruda

enum class ErudaButtons(val text: String) {
    WORKING_TIME("Режим работы базы Еруда"),
    MTR_ERUDA_WAREHOUSE("Склад МТР Еруда");

    enum class ErudaWorkingTimeButtons(val text: String) {
        WAREHOUSE_WORKING_TIME("Режим работы складов базы Еруда"),
        KITCHEN_WORKING_TIME("Режим работы столовой базы Еруда"),
    }

    enum class ErudaMTRButtons(val text: String) {
        MTR_WORKING_TIME("Режим работы склада МТР"),
        MTR_WAREHOUSE_SCHEME("Схема склада МТР (PDF)")
    }
}