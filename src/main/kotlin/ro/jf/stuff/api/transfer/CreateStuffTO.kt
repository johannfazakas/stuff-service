package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable

@Serializable
data class CreateStuffTO(
    val name: String,
    val value: Int,
    val flag: Boolean,
    val list: List<String>,
)
