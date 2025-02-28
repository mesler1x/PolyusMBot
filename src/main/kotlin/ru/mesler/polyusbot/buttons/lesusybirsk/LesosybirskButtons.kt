package ru.mesler.polyusbot.buttons.lesusybirsk

enum class LesosybirskButtons(val text: String) {
    WORKING_TIME("Режим работы базы Лесосибрск"),
    SCHEME_PLAN_A("Схема площадок А базы Лесосибрск"),
    SCHEME_PLAN_B("Схема площадок Б базы Лесосибрск");

    enum class LesosybirskWorkingTimeButtons(val text: String) {
        WAREHOUSE_WORKING_TIME("Режим работы складов базы Лесосибирск"),
        KITCHEN_WORKING_TIME("Режим работы столовой базы Лесосибирск");
    }
}