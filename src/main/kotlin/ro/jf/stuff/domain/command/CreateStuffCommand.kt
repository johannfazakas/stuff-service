package ro.jf.stuff.domain.command

import ro.jf.stuff.domain.model.Stuff
import java.time.LocalDateTime
import java.util.UUID.randomUUID

data class CreateStuffCommand(
    val name: String,
    val value: Int,
    val flag: Boolean,
    val dateTime: LocalDateTime,
    val list: List<String>,
) {
    fun toModel(): Stuff = Stuff(
        id = randomUUID(),
        name = name,
        value = value,
        flag = flag,
        dateTime = dateTime,
        list = list,
    )
}
