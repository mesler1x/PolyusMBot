package ru.mesler.polyusbot.service.commands.api

interface TextCommand: Command{
    fun getText(): String
}