package ru.mesler.polyusbot.service.commands.edc

import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.buttons.StartInputButtons
import ru.mesler.polyusbot.buttons.edc.EdcButtons
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.util.MessageTexts.CONTINUE_MESSAGE

@Service
class EdcFirstButtonCommand : ButtonCommand {
    override fun getButtons(update: Update): KeyboardRow {
        val contactNumbersEdc = KeyboardButton(EdcButtons.CONTACT_NUMBERS.text)
        val chatEdc = KeyboardButton(EdcButtons.CHAT_QUEUE_EDC.text)
        val chatLesosybirsk = KeyboardButton(EdcButtons.CHAT_QUEUE_LESOSYBIRSK.text)
        return KeyboardRow(contactNumbersEdc, chatEdc, chatLesosybirsk)
    }

    override fun getParentCommandName(): String = StartInputButtons.EDC.text

    override fun getMessageText(): String = CONTINUE_MESSAGE.text
}