package ru.mesler.polyusbot.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.ParseMode
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.service.commands.api.DocumentCommand
import ru.mesler.polyusbot.service.commands.api.TextCommand
import ru.mesler.polyusbot.util.CommandNames
import ru.mesler.polyusbot.util.Constants

@Component
class CommandsHandler{

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun handleSendMessageCommand(update: Update, buttonCommandMap: MutableMap<String, ButtonCommand>): SendMessage {
        logger.info("Command in chat ${update.message?.chatId} has been received")
        val messageText = update.message?.text ?: throw IllegalArgumentException()
        val chatId = update.message?.chat?.id ?: throw IllegalArgumentException()

        val buttonCommandHandler =
            buttonCommandMap[messageText] ?: return SendMessage(chatId.toString(), Constants.UNKNOWN_COMMAND.message)
        val buttons = buttonCommandHandler.getButtons(update)
        val sendMessage = SendMessage
            .builder()
            .chatId(chatId)
            .text(buttonCommandHandler.getMessageText())
            .build()

        val keyboardMarkUp = concatenateButtonsAndHome(buttons)

        sendMessage.replyMarkup = keyboardMarkUp
        return sendMessage
    }

    fun handleSendDocumentCommand(
        update: Update,
        documentCommandMap: MutableMap<String, DocumentCommand>
    ): SendDocument {
        val chatId = update.message?.chat?.id ?: throw IllegalArgumentException()
        val messageText = update.message?.text ?: throw IllegalArgumentException()
        val documentCommandHandler = documentCommandMap[messageText] ?: return SendDocument.builder().chatId(chatId)
            .caption(Constants.UNKNOWN_COMMAND.message).build()
        val file = documentCommandHandler.getDocument()
        val documentMessage = SendDocument
            .builder()
            .chatId(chatId)
            .document(InputFile(file))
            .caption(documentCommandHandler.getCaption())
            .build()

        return documentMessage
    }

    fun handleSendTextCommand(update: Update, textCommandMap: MutableMap<String, TextCommand>): SendMessage {
        val chatId = update.message?.chat?.id ?: throw IllegalArgumentException()
        val messageText = update.message?.text ?: throw IllegalArgumentException()
        val textCommandHandler = textCommandMap[messageText] ?: return SendMessage(chatId.toString(), Constants.UNKNOWN_COMMAND.message)
        val sendMessage = SendMessage
            .builder()
            .chatId(chatId)
            .text(textCommandHandler.getText())
            .parseMode(ParseMode.HTML)
            .build()
        val keyboardMarkUp = concatenateButtonsAndHome(KeyboardRow())
        sendMessage.replyMarkup = keyboardMarkUp
        return sendMessage
    }

    private fun concatenateButtonsAndHome(buttons: KeyboardRow): ReplyKeyboardMarkup? =
        ReplyKeyboardMarkup
            .builder()
            .keyboard(listOf(buttons, getHomeRow()))
            .resizeKeyboard(true)
            .oneTimeKeyboard(true)
            .build()

    fun getHomeRow(): KeyboardRow {
        val homeButton = KeyboardButton(CommandNames.HOME_COMMAND.text)
        val homeRow = KeyboardRow(homeButton)
        return homeRow
    }
}