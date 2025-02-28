package ru.mesler.polyusbot.service.commands.edc.text

import org.springframework.stereotype.Service
import ru.mesler.polyusbot.buttons.edc.EdcButtons
import ru.mesler.polyusbot.service.commands.api.TextCommand

@Service
class EdcLQueueChatTextCommand : TextCommand {
    override fun getText(): String {
        return "@gentoomemes"
    }

    override fun getParentCommandName(): String = EdcButtons.CHAT_QUEUE_LESOSYBIRSK.text
}