package ru.mesler.polyusbot.bot

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import ru.mesler.polyusbot.service.CommandsHandler
import ru.mesler.polyusbot.service.commands.api.ButtonCommand
import ru.mesler.polyusbot.service.commands.api.DocumentCommand
import ru.mesler.polyusbot.service.commands.api.TextCommand
import java.util.concurrent.TimeUnit


@Component
class TelegramBot(
    private val commandsHandler: CommandsHandler,
    private val telegramClient: OkHttpTelegramClient,
    private val buttonCommands: List<ButtonCommand>,
    private val documentCommands: List<DocumentCommand>,
    private val textCommands: List<TextCommand>,
) : LongPollingSingleThreadUpdateConsumer {


    private val buttonCommandMap: MutableMap<String, ButtonCommand> = buttonCommands.associateBy {
        it.getParentCommandName()
    }.toMutableMap()

    private val documentCommandMap: MutableMap<String, DocumentCommand> = documentCommands.associateBy {
        it.getParentCommandName()
    }.toMutableMap()

    private val textCommandMap: MutableMap<String, TextCommand> = textCommands.associateBy {
        it.getParentCommandName()
    }.toMutableMap()


    private var logger = LoggerFactory.getLogger(this::class.java)

    private fun sendDocument(sendDocument: SendDocument) {
        try {
            telegramClient.executeAsync(sendDocument).get(10L, TimeUnit.SECONDS)
        } catch (e: TelegramApiException) {
            logger.error(e.message)
        }
    }

    override fun consume(update: Update?) {
        if (update!!.hasMessage() && update.message.hasText()) {
            val messageText = update.message?.text ?: throw IllegalArgumentException()
            if (buttonCommandMap.containsKey(messageText)){
                sendMessage(commandsHandler.handleSendMessageCommand(update, buttonCommandMap))
            } else if (documentCommandMap.containsKey(messageText)) {
                sendDocument(commandsHandler.handleSendDocumentCommand(update, documentCommandMap))
            } else if (textCommandMap.containsKey(messageText)) {
                sendMessage(commandsHandler.handleSendTextCommand(update, textCommandMap))
            }
        }
    }

    private fun sendMessage(sendMessage: SendMessage) {
        try {
            telegramClient.executeAsync(sendMessage).get(10L, TimeUnit.SECONDS)
        } catch (e: TelegramApiException) {
            logger.error(e.message)
        }
    }
}