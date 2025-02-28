package ru.mesler.polyusbot.service.commands.lesosybirsk.button

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.buttons.StartInputButtons
import ru.mesler.polyusbot.buttons.lesusybirsk.LesosybirskButtons
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.util.MessageTexts.CONTINUE_MESSAGE

@Component
class LFirstButtonCommand : ButtonCommand {
    override fun getButtons(update: Update): KeyboardRow {
        val lesosybirskButton = KeyboardButton(LesosybirskButtons.WORKING_TIME.text)
        val erudaButton = KeyboardButton(LesosybirskButtons.SCHEME_PLAN_A.text)
        val edcButton = KeyboardButton(LesosybirskButtons.SCHEME_PLAN_B.text)

        return KeyboardRow(lesosybirskButton, erudaButton, edcButton)
    }

    override fun getParentCommandName(): String = StartInputButtons.LESOSYBIRSK_BASE.text

    override fun getMessageText(): String = CONTINUE_MESSAGE.text
}
