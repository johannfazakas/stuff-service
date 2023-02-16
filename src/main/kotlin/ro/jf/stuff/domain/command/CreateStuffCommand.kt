package ro.jf.stuff.domain.command

import ro.jf.stuff.domain.model.Stuff
import java.util.UUID.randomUUID

data class CreateStuffCommand(
    val name: String,
    val value: Int,
    val flag: Boolean,
    val list: List<String>,
) {
    fun toModel(): Stuff = Stuff(
        id = randomUUID(),
        name = name,
        value = value,
        flag = flag,
        list = list,
    )
}
