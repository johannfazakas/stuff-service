package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable
import ro.jf.stuff.api.transfer.serializer.LocalDateTimeSerializer
import ro.jf.stuff.domain.command.CreateStuffCommand
import java.time.LocalDateTime

@Serializable
data class CreateStuffTO(
    val name: String,
    val value: Int,
    val flag: Boolean,
    @Serializable(with = LocalDateTimeSerializer::class)
    val dateTime: LocalDateTime,
    val list: List<String>,
) {
    fun toCommand(): CreateStuffCommand = CreateStuffCommand(
        name = name,
        value = value,
        flag = flag,
        dateTime = dateTime,
        list = list,
    )
}
