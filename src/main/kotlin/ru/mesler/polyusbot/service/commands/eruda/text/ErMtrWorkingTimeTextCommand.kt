package ru.mesler.polyusbot.service.commands.eruda.text

import org.springframework.stereotype.Service
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons.ErudaMTRButtons.MTR_WORKING_TIME
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Service
class ErMtrWorkingTimeTextCommand : TextCommand {
    override fun getText(): String = """
        Тут будут часы работы базы МТР
    """.trimIndent()

    override fun getParentCommandName(): String = MTR_WORKING_TIME.text
}