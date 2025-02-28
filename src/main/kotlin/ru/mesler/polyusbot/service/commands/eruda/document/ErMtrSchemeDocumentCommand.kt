package ru.mesler.polyusbot.service.commands.eruda.document

import org.springframework.stereotype.Component
import ru.mesler.polyusbot.buttons.eruda.ErudaButtons
import ru.mesler.polyusbot.service.commands.api.DocumentCommand
import java.io.File

@Component
class ErMtrSchemeDocumentCommand : DocumentCommand {
    override fun getDocument(): File {
        return File.createTempFile("some file", "pdf")
    }

    override fun getParentCommandName(): String = ErudaButtons.ErudaMTRButtons.MTR_WAREHOUSE_SCHEME.text

    override fun getCaption(): String = "Схема склада МТР"
}