package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable
import ro.jf.stuff.domain.model.Stuff

@Serializable
data class StuffTO(
    // TODO(Johann) use UUID instead of String
    val id: String,
    val name: String,
    val value: Int,
    val flag: Boolean,
    // TODO(Johann) serialize LocalDateTime
//    val date: LocalDateTime,
    val list: List<String>,
) {
    companion object {
        fun fromDomain(stuff: Stuff) = StuffTO(
            id = stuff.id.toString(),
            name = stuff.name,
            value = stuff.value,
            flag = stuff.flag,
            list = stuff.list,
        )
    }
}
