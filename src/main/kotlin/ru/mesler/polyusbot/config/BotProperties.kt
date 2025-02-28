package ru.mesler.polyusbot.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "tg.bot")
class BotProperties {
    lateinit var username: String
    lateinit var token: String
}