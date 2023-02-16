package ro.jf.stuff.domain.model

import java.util.UUID

data class Stuff(
    val id: UUID,
    val name: String,
    val value: Int,
    val flag: Boolean,
    val list: List<String>,
) {
    companion object {
        fun random() = Stuff(
            id = UUID.randomUUID(),
            name = "Stuff",
            value = 123,
            flag = true,
            list = listOf("a", "b", "c"),
        )
    }
}
