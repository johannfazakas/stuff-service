package ro.jf.stuff.api

import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import ro.jf.stuff.api.transfer.StuffTO
import ro.jf.stuff.utils.jsonClient
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
        assertEquals(2, stuff.size)
        assertEquals("Stuff", stuff[0].name)
    }

    @Test
    fun `should get stuff by id`(): Unit = testApplication {
        val client = jsonClient()
        val response = client.get("/api/v1/stuff/123")
        assertEquals(HttpStatusCode.OK, response.status)
        val stuff = response.body<StuffTO>()
        assertEquals("Stuff", stuff.name)
    }

    @Test
    fun `should create stuff`() = testApplication {
        val client = jsonClient()
        val response = client.post("/api/v1/stuff")
        assertEquals(HttpStatusCode.Created, response.status)
        val stuff = response.body<StuffTO>()
        assertEquals("Stuff", stuff.name)
    }

    @Test
    fun `should update stuff`() = testApplication {
        val client = jsonClient()
        val response = client.put("/api/v1/stuff/123")
        assertEquals(HttpStatusCode.OK, response.status)
        val stuff = response.body<StuffTO>()
        assertEquals("Stuff", stuff.name)
    }

    @Test
    fun `should delete stuff`() = testApplication {
        val response = client.delete("/api/v1/stuff/123")
        assertEquals(HttpStatusCode.NoContent, response.status)
        assertTrue(response.body<String>().isEmpty())
    }
}
