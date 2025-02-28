package ru.mesler.polyusbot.service.commands.edc.text

import org.springframework.stereotype.Service
import ru.mesler.polyusbot.buttons.edc.EdcButtons
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Service
class EdcContactsTextCommand : TextCommand {
    override fun getText(): String {
        return """Тут будут конактные данные ЕДЦ"""
    }

    override fun getParentCommandName(): String = EdcButtons.CONTACT_NUMBERS.text
}