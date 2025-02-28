package ru.mesler.polyusbot.service.commands.common

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.util.CommandNames
import ru.mesler.polyusbot.util.MessageTexts

@Component
class EndCommand(
    private val startCommand: StartCommand
) : ButtonCommand {

    override fun getButtons(update: Update): KeyboardRow {
        return startCommand.getButtons(update)
    }

    override fun getParentCommandName(): String = CommandNames.HOME_COMMAND.text

    override fun getMessageText(): String = MessageTexts.START_MESSAGE.text
}