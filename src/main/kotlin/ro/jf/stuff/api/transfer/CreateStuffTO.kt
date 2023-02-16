package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable
import ro.jf.stuff.domain.command.CreateStuffCommand

@Serializable
data class CreateStuffTO(
    val name: String,
    val value: Int,
    val flag: Boolean,
    val list: List<String>,
) {
    fun toCommand(): CreateStuffCommand = CreateStuffCommand(
        name = name,
        value = value,
        flag = flag,
        list = list,
    )
}
