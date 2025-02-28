package ru.mesler.polyusbot.service.commands.edc.text

import org.springframework.stereotype.Component
import ru.mesler.polyusbot.buttons.edc.EdcButtons
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Component
class EdcQueueChatTextCommand : TextCommand {

    override fun getText(): String {
        return "@gentoomemes"
    }

    override fun getParentCommandName(): String = EdcButtons.CHAT_QUEUE_EDC.text
}