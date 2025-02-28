package ru.mesler.polyusbot.service.commands.eruda.button

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons.ErudaMTRButtons.MTR_WAREHOUSE_SCHEME
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons.ErudaMTRButtons.MTR_WORKING_TIME
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.util.MessageTexts

@Component
class ErMTRButtonCommand : ButtonCommand {
    override fun getButtons(update: Update): KeyboardRow {
        val mtrWorkingTime = KeyboardButton(MTR_WORKING_TIME.text)
        val mtrWarehouseScheme = KeyboardButton(MTR_WAREHOUSE_SCHEME.text)
        return KeyboardRow(mtrWorkingTime, mtrWarehouseScheme)
    }

    override fun getParentCommandName(): String = ErudaButtons.MTR_ERUDA_WAREHOUSE.text

    override fun getMessageText(): String = MessageTexts.CONTINUE_MESSAGE.text
}