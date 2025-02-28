package ru.mesler.polyusbot.service.commands.lesosybirsk.document

import org.springframework.stereotype.Component
import ru.mesler.polyusbot.buttons.lesusybirsk.LesosybirskButtons
import ru.mesler.polyusbot.service.commands.api.DocumentCommand
import java.io.File
import java.nio.file.Paths

@Component
class LSchemeADocumentCommand : DocumentCommand {
    override fun getDocument(): File {
        return Paths.get("src/main/resources/static/schemes/A_SCHEME_LES.pdf").toFile()
    }

    override fun getParentCommandName(): String {
        return LesosybirskButtons.SCHEME_PLAN_A.text
    }

    override fun getCaption(): String = "Схема площадки А"
}