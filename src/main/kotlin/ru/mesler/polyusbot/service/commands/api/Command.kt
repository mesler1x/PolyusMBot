package ru.mesler.polyusbot.service.commands.api

interface Command {
    fun getParentCommandName(): String
}