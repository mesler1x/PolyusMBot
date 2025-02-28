package ru.mesler.polyusbot.service.commands.lesosybirsk.text

import org.springframework.stereotype.Service
import ru.mesler.polyusbot.buttons.lesusybirsk.LesosybirskButtons.LesosybirskWorkingTimeButtons
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Service
class LWarehousTimeText : TextCommand {
    override fun getText(): String =
        """
            Тут будет время работы Лесосибирского склада
        """.trimIndent()


    override fun getParentCommandName(): String = LesosybirskWorkingTimeButtons.WAREHOUSE_WORKING_TIME.text
}