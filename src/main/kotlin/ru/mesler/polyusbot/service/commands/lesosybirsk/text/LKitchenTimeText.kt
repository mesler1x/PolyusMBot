package ru.mesler.polyusbot.service.commands.lesosybirsk.text

import org.springframework.stereotype.Component
import ru.mesler.polyusbot.buttons.lesusybirsk.LesosybirskButtons.LesosybirskWorkingTimeButtons
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Component
class LKitchenTimeText: TextCommand {

    override fun getText(): String =
        """
            Тут будет время работы Столовой 
        """.trimIndent()


    override fun getParentCommandName(): String = LesosybirskWorkingTimeButtons.KITCHEN_WORKING_TIME.text
}