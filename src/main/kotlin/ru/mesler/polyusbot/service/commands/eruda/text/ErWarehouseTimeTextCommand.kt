package ru.mesler.polyusbot.service.commands.eruda.text

import org.springframework.stereotype.Service
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons.ErudaWorkingTimeButtons.WAREHOUSE_WORKING_TIME
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Service
class ErWarehouseTimeTextCommand : TextCommand {
    override fun getText(): String = """
        Тут будут часы работы базы Еруда
    """.trimIndent()

    override fun getParentCommandName(): String = WAREHOUSE_WORKING_TIME.text
}