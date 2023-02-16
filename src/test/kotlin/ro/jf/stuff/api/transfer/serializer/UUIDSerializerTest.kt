package ro.jf.stuff.api.transfer.serializer

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.junit.Test
import java.util.UUID
import kotlin.test.assertEquals

@Serializable
private data class ResourceWithUUID(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
)

class UUIDSerializerTest {
    @Test
    fun `should serialize uuid`() {
        val resource = ResourceWithUUID(UUID.randomUUID())

        val json = Json.encodeToString(ResourceWithUUID.serializer(), resource)

        assertEquals("""{"id":"${resource.id}"}""", json)
    }

    @Test
    fun `should deserialize uuid`() {
        val resource = ResourceWithUUID(UUID.randomUUID())

        val json = Json.decodeFromString(ResourceWithUUID.serializer(), """{"id":"${resource.id}"}""")

        assertEquals(resource, json)
    }
}