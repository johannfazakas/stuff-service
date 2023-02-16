package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable
import ro.jf.stuff.domain.command.UpdateStuffCommand
import java.util.UUID

@Serializable
data class UpdateStuffTO(
    val name: String,
) {
    fun toCommand(id: UUID): UpdateStuffCommand = UpdateStuffCommand(
        id = id,
        name = name,
    )
}
