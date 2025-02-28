package ru.mesler.polyusbot.service.commands.eruda.button

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons.ErudaWorkingTimeButtons
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons.ErudaWorkingTimeButtons.*
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.util.MessageTexts

@Component
class ErWorkingHoursButtonCommand: ButtonCommand{
    override fun getButtons(update: Update): KeyboardRow {
        val warehouseTime = KeyboardButton(WAREHOUSE_WORKING_TIME.text)
        val kitchenTime = KeyboardButton(KITCHEN_WORKING_TIME.text)
        return KeyboardRow(warehouseTime, kitchenTime)
    }

    override fun getParentCommandName(): String = ErudaButtons.WORKING_TIME.text

    override fun getMessageText(): String = MessageTexts.CONTINUE_MESSAGE.text
}