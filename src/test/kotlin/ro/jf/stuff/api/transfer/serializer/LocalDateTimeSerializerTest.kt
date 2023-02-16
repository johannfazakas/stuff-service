package ro.jf.stuff.api.transfer.serializer

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.junit.Test
import java.time.LocalDateTime
import java.time.Month.FEBRUARY
import kotlin.test.assertEquals

@Serializable
private data class ResourceWithLocalDateTime(
    @Serializable(with = LocalDateTimeSerializer::class)
    val dateTime: LocalDateTime,
)

class LocalDateTimeSerializerTest {
    @Test
    fun `should serialize local date time`() {
        val dateTime = LocalDateTime.of(2023, FEBRUARY, 16, 19, 48, 23)
        val resource = ResourceWithLocalDateTime(dateTime)

        val json = Json.encodeToString(ResourceWithLocalDateTime.serializer(), resource)

        assertEquals("""{"dateTime":"2023-02-16T19:48:23"}""", json)
    }

    @Test
    fun `should deserialize local date time`() {
        val dateTime = LocalDateTime.of(2023, FEBRUARY, 16, 19, 48, 23)
        val resource = ResourceWithLocalDateTime(dateTime)

        val json = Json.decodeFromString(ResourceWithLocalDateTime.serializer(), """{"dateTime":"2023-02-16T19:48:23"}""")

        assertEquals(resource, json)
    }
}