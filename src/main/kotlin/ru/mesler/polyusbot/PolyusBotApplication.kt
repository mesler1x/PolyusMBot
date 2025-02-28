package ru.mesler.polyusbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.mesler.polyusbot.config.BotProperties

@SpringBootApplication
@EnableConfigurationProperties(BotProperties::class)
class PolyusBotApplication

fun main(args: Array<String>) {
    runApplication<PolyusBotApplication>(*args)
}
