package ru.mesler.polyusbot.service.commands.common

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.buttons.StartInputButtons
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.util.CommandNames.START_COMMAND
import ru.mesler.polyusbot.util.MessageTexts


@Component
class StartCommand : ButtonCommand {
    override fun getButtons(update: Update): KeyboardRow {
        val lesosybirskButton = KeyboardButton(StartInputButtons.LESOSYBIRSK_BASE.text)
        val erudaButton = KeyboardButton(StartInputButtons.ERUDA_WAREHOUSE.text)
        val edcButton = KeyboardButton(StartInputButtons.EDC.text)
        return KeyboardRow(lesosybirskButton, erudaButton, edcButton)
    }

    override fun getParentCommandName(): String = START_COMMAND.text

    override fun getMessageText(): String = MessageTexts.START_MESSAGE.text
}