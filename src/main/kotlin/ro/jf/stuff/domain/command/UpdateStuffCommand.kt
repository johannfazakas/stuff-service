package ro.jf.stuff.domain.command

import java.util.UUID

data class UpdateStuffCommand(
    val id: UUID,
    val name: String,
)
