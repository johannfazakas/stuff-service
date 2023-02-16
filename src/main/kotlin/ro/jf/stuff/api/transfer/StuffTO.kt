package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable
import java.util.UUID
import java.util.UUID.randomUUID

@Serializable
data class StuffTO(
    val id: String,
    val name: String,
    val value: Int,
    val flag: Boolean,
//    val date: LocalDateTime,
    val list: List<String>,
) {
    companion object {
        fun random() = StuffTO(
            id = randomUUID().toString(),
            name = "Stuff",
            value = 123,
            flag = true,
            list = listOf("a", "b", "c"),
        )

        fun withId(id: UUID) = random().copy(id = id.toString())
    }
}
