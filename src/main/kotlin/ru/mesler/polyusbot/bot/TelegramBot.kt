package ru.mesler.polyusbot.bot

import org.springframework.stereotype.Component
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class TelegramBot: LongPollingSingleThreadUpdateConsumer {

    override fun consume(update: Update?) {
        val a = 0
    }
}