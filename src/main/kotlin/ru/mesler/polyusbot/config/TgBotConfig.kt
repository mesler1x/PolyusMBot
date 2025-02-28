package ru.mesler.polyusbot.config

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication
import ru.mesler.polyusbot.bot.TelegramBot
import java.util.concurrent.TimeUnit

@Configuration
class TgBotConfig {
    @Bean
    fun telegramBotConfiguration(bot: TelegramBot, botProperties: BotProperties): TelegramBotsLongPollingApplication {
        val objectMapper = ObjectMapper()
        val botsApp = TelegramBotsLongPollingApplication({ objectMapper }, { okHttClient() })
        return telegramLongPollingApplication(botProperties, botsApp, bot)
    }

    @Bean
    fun telegramClient(botProperties: BotProperties): OkHttpTelegramClient =
        OkHttpTelegramClient(okHttClient(), botProperties.token)


    private fun telegramLongPollingApplication(
        botProperties: BotProperties,
        botsApp: TelegramBotsLongPollingApplication,
        bot: TelegramBot
    ): TelegramBotsLongPollingApplication {
        botsApp.registerBot(botProperties.token, bot)
        return botsApp
    }

    private fun okHttClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
}