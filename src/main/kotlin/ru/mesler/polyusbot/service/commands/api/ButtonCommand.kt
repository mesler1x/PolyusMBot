package ru.mesler.polyusbot.service.commands.api

import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow

interface ButtonCommand : Command {
    fun getButtons(update: Update): KeyboardRow
    fun getMessageText(): String
}