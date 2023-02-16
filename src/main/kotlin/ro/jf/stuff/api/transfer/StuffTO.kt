package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable
import java.util.UUID.randomUUID

@Serializable
data class StuffTO(
    val id: Int,
    val name: String,
    val value: Int,
    val flag: Boolean,
//    val date: LocalDateTime,
    val list: List<String>,
) {
    companion object {
        fun random() = StuffTO(
            id = randomUUID().hashCode(),
            name = "Stuff",
            value = 123,
            flag = true,
            list = listOf("a", "b", "c"),
        )
    }
}
