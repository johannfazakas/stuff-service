package ro.jf.stuff.api

import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.server.testing.testApplication
import ro.jf.stuff.api.transfer.CreateStuffTO
import ro.jf.stuff.api.transfer.StuffTO
import ro.jf.stuff.api.transfer.UpdateStuffTO
import ro.jf.stuff.utils.jsonClient
import java.time.LocalDateTime
import java.util.UUID.randomUUID
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StuffApiTest {

    @Test
    fun `should get stuff`() = testApplication {
        val client = jsonClient()

        val response = client.get("/api/v1/stuff")

        assertEquals(HttpStatusCode.OK, response.status)
        val stuff = response.body<List<StuffTO>>()
        assertEquals(3, stuff.size)
        assertEquals("Stuff", stuff[0].name)
    }

    @Test
    fun `should get stuff by id`(): Unit = testApplication {
        val client = jsonClient()
        val stuffId = client.get("/api/v1/stuff").body<List<StuffTO>>()[0].id

        val response = client.get("/api/v1/stuff/$stuffId")

        assertEquals(HttpStatusCode.OK, response.status)
        val stuff = response.body<StuffTO>()
        assertEquals(stuffId, stuff.id)
        assertEquals("Stuff", stuff.name)
    }

    @Test
    fun `should create stuff`() = testApplication {
        val client = jsonClient()
        val createStuffTO = CreateStuffTO(
            name = "Test name",
            value = 123,
            flag = true,
            dateTime = LocalDateTime.now(),
            list = listOf("a", "b"),
        )

        val response = client.post("/api/v1/stuff") {
            contentType(ContentType.Application.Json)
            setBody(createStuffTO)
        }

        assertEquals(HttpStatusCode.Created, response.status)
        val stuff = response.body<StuffTO>()
        assertEquals("Test name", stuff.name)
    }

    @Test
    fun `should update stuff`() = testApplication {
        val client = jsonClient()
        val stuffId = client.get("/api/v1/stuff").body<List<StuffTO>>()[0].id
        val updateStuffTO = UpdateStuffTO(
            name = "Updated name"
        )

        val response = client.put("/api/v1/stuff/$stuffId") {
            contentType(ContentType.Application.Json)
            setBody(updateStuffTO)
        }

        assertEquals(HttpStatusCode.OK, response.status)
        val stuff = response.body<StuffTO>()
        assertEquals(stuffId, stuff.id)
        assertEquals("Updated name", stuff.name)
    }

    @Test
    fun `should delete stuff`() = testApplication {
        val client = jsonClient()
        val stuffId = randomUUID()

        val response = client.delete("/api/v1/stuff/$stuffId")

        assertEquals(HttpStatusCode.NoContent, response.status)
        assertTrue(response.body<String>().isEmpty())
    }
}
