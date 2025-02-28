package ru.mesler.polyusbot.service.commands.api

import java.io.File

interface DocumentCommand : Command {
    fun getDocument(): File
    fun getCaption(): String
}