package ru.mesler.polyusbot.service.commands.edc.text

import org.springframework.stereotype.Service
import ru.mesler.polyusbot.buttons.edc.EdcButtons
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Service
class EdcQueueChatTextCommand : TextCommand {

    override fun getText(): String {
        return "@gentoomemes"
    }

    override fun getParentCommandName(): String = EdcButtons.CHAT_QUEUE_EDC.text
}