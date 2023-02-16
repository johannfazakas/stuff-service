package ro.jf.stuff.api.transfer

import kotlinx.serialization.Serializable

@Serializable
data class UpdateStuffTO(
    val name: String,
)
