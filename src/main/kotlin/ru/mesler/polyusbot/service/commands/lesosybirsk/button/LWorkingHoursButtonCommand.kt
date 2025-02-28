package ru.mesler.polyusbot.service.commands.lesosybirsk.button

import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.buttons.lesusybirsk.LesosybirskButtons.LesosybirskWorkingTimeButtons
import ru.mesler.polyusbot.buttons.lesusybirsk.LesosybirskButtons.WORKING_TIME
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.util.MessageTexts

@Service
class LWorkingHoursButtonCommand : ButtonCommand {
    override fun getButtons(update: Update): KeyboardRow {
        val warehouseTime = KeyboardButton(LesosybirskWorkingTimeButtons.WAREHOUSE_WORKING_TIME.text)
        val kitchenTime = KeyboardButton(LesosybirskWorkingTimeButtons.KITCHEN_WORKING_TIME.text)
        return KeyboardRow(warehouseTime, kitchenTime)
    }

    override fun getParentCommandName(): String = WORKING_TIME.text

    override fun getMessageText(): String = MessageTexts.CONTINUE_MESSAGE.text
}