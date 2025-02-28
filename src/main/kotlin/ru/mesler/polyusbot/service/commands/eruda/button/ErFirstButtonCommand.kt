package ru.mesler.polyusbot.service.commands.eruda.button

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.buttons.StartInputButtons
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.util.MessageTexts.CONTINUE_MESSAGE

@Component
class ErFirstButtonCommand : ButtonCommand {

    override fun getButtons(update: Update): KeyboardRow {
        val workingTime = KeyboardButton(ErudaButtons.WORKING_TIME.text)
        val mtrEruda = KeyboardButton(ErudaButtons.MTR_ERUDA_WAREHOUSE.text)
        return KeyboardRow(workingTime, mtrEruda)
    }

    override fun getParentCommandName(): String = StartInputButtons.ERUDA_WAREHOUSE.text

    override fun getMessageText(): String = CONTINUE_MESSAGE.text
}