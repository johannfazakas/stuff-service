package ro.jf.stuff.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class Stuff(
    val id: UUID,
    val name: String,
    val value: Int,
    val flag: Boolean,
    val dateTime: LocalDateTime,
    val list: List<String>,
) {
    companion object {
        fun random() = Stuff(
            id = UUID.randomUUID(),
            name = "Stuff",
            value = 123,
            flag = true,
            dateTime = LocalDateTime.now(),
            list = listOf("a", "b", "c"),
        )
    }
}
