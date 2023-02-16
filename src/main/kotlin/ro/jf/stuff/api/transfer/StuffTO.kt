package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable
import ro.jf.stuff.api.transfer.serializer.UUIDSerializer
import ro.jf.stuff.domain.model.Stuff
import java.util.UUID

@Serializable
data class StuffTO(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val value: Int,
    val flag: Boolean,
    // TODO(Johann) serialize LocalDateTime
//    val date: LocalDateTime,
    val list: List<String>,
) {
    companion object {
        fun fromDomain(stuff: Stuff) = StuffTO(
            id = stuff.id,
            name = stuff.name,
            value = stuff.value,
            flag = stuff.flag,
            list = stuff.list,
        )
    }
}
