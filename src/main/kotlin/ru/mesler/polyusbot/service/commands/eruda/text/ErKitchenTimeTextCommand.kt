package ru.mesler.polyusbot.service.commands.eruda.text

import org.springframework.stereotype.Component
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons.ErudaWorkingTimeButtons.KITCHEN_WORKING_TIME
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Component
class ErKitchenTimeTextCommand : TextCommand {
    override fun getText(): String = """
        Тут будут часы работы столовой базы Еруда
    """.trimIndent()

    override fun getParentCommandName(): String = KITCHEN_WORKING_TIME.text
}