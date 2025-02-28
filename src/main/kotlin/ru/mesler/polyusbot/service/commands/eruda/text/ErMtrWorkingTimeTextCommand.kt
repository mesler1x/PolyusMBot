package ru.mesler.polyusbot.service.commands.eruda.text

import org.springframework.stereotype.Component
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons.ErudaMTRButtons.MTR_WORKING_TIME
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Component
class ErMtrWorkingTimeTextCommand: TextCommand {
    override fun getText(): String = """
        Тут будут часы работы базы МТР
    """.trimIndent()

    override fun getParentCommandName(): String = MTR_WORKING_TIME.text
}